package com.ciastek.tictactoegame;

import java.util.Arrays;

public class Board {
    private int size;
    private PlayerCharacter[][] characterBoard; //TODO: change to String[][]?

    public Board(int size){
        this.size = size;
        characterBoard = new PlayerCharacter[size][size];
    }

    public int getSize(){
        return size;
    }

    public void add(int x, int y, PlayerCharacter character) {
        validateCoordinates(x, y);

        characterBoard[x][y] = character;
    }

    private void validateCoordinates(int x, int y) {
        validate(x);
        validate(y);
        isFieldOccupied(x, y);
    }

    public PlayerCharacter[][] getCharacterBoard() {
        return characterBoard;
    }

    private void validate(int coordinate){
        if(coordinate < 1) {
            throw new IllegalArgumentException("Coordinates smaller than 1");
        } else if(coordinate > size){
            throw new IllegalArgumentException("Coordinates greater than board size");
        }
    }

    private void isFieldOccupied(int x, int y) {
        if(characterBoard[x][y] != null){
            throw new IllegalArgumentException("Field is already occupied");
        }
    }
}
