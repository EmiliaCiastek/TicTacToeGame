package com.ciastek.tictactoegame;

public class Board {
    private int size;
    private PlayerCharacter[][] characterBoard;

    public Board(int size){
        this.size = size;
        characterBoard = new PlayerCharacter[size][size];
        initializeBoard();
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
        if(characterBoard[x][y] != PlayerCharacter.NONE){
            throw new IllegalArgumentException("Field is already occupied");
        }
    }

    private void initializeBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                characterBoard[i][j] = PlayerCharacter.NONE;
            }
        }
    }
}
