package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

public class MovementValidator {
    private Board gameBoard;
    private ValidationState validationState;

    public MovementValidator(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

/*    public boolean isValid(int index) {
        BoardDimensions dimensions = gameBoard.getBoardDimensions();
        int boardSize = dimensions.getWidth() * dimensions.getHeight();

        if(index < 0 || index >= boardSize){
            validationState = ValidationState.OUT_OF_BOUNDS;
            return false;
        } else if(gameBoard.getCharacterAt(index) != PlayerCharacter.NONE){
            validationState = ValidationState.OCCUPIED;
            return false;
        }

        validationState = ValidationState.VALID;
        return true;
    } */

    public ValidationState isValid(int index) {
        BoardDimensions dimensions = gameBoard.getBoardDimensions();
        int boardSize = dimensions.getWidth() * dimensions.getHeight();

        if(index < 0 || index >= boardSize){
            return ValidationState.OUT_OF_BOUNDS;
        } else if(gameBoard.getCharacterAt(index) != PlayerCharacter.NONE){
            return ValidationState.OCCUPIED;
        }

        return ValidationState.VALID;
    }

    public ValidationState getValidationState() {
        return validationState;
    }
}