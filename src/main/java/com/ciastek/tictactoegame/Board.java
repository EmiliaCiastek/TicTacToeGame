package com.ciastek.tictactoegame;

public class Board {
    private int size;
    private PlayerCharacter[][] characterBoard;

    public Board(int size){
        this.size = size;
        characterBoard = new PlayerCharacter[size][size];
    }

    public int getSize(){
        return size;
    }

    public void add(int x, int y, PlayerCharacter character) {
        if(x < 1 || y < 1) {
            throw new IllegalArgumentException("Coordinates smaller than 1");
        } else if(x > size || y > size){
            throw new IllegalArgumentException("Coordinates greater than board size");
        } else if(characterBoard[x][y] != null){
            throw new IllegalArgumentException("Field is already occupied");
        }

        characterBoard[x][y] = character;

    }

    public PlayerCharacter[][] getCharacterBoard() {
        return characterBoard;
    }
}
