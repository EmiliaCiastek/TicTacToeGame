package com.ciastek.tictactoegame;

public class MovementValidator {
    private Board gameBoard;

    public MovementValidator(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void validate(int x, int y) throws IllegalArgumentException {
        if(x < 1 || y < 1) {
            throw new IllegalArgumentException("Coordinates have to be equals or greater than 1");
        } else if(x > gameBoard.getWidth() || y > gameBoard.getHeight()){
            throw new IllegalArgumentException("Coordinates have to be equals or smaller than board size");
        }

        if (gameBoard.getCharacterAt(x, y) != PlayerCharacter.NONE) {
            throw new IllegalArgumentException("Field is already occupied");
        }

    }
}
