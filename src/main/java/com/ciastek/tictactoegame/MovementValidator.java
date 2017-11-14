package com.ciastek.tictactoegame;

public class MovementValidator {
    private Board gameBoard;

    public MovementValidator(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void validate(int index) throws IllegalArgumentException { //TODO: fix validate method: x y -> index
        if(index < 0) {
            throw new IllegalArgumentException("Coordinates have to be equals or greater than 0");
        } else if(index > gameBoard.getCharacterBoard().size()){
            throw new IllegalArgumentException("Coordinates have to be equals or smaller than board size");
        }

        if (gameBoard.getCharacterAt(index) != PlayerCharacter.NONE) {
            throw new IllegalArgumentException("Field is already occupied");
        }

    }
}
