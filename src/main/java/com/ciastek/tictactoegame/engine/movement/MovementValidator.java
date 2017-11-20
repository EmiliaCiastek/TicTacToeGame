package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.engine.board.Board;

public class MovementValidator {
    private Board gameBoard;

    // TODO: Create Movements collection (Game History?) (hashMap? ) if contains Movement -> field is occupied
    public MovementValidator(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void validate(int index) throws IllegalArgumentException {
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