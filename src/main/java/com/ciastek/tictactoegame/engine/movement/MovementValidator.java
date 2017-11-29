package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

public class MovementValidator {
    private Board gameBoard;

    public MovementValidator(Board gameBoard) {
        this.gameBoard = gameBoard;
    }


    public ValidationState isValid(int index) {
        BoardDimensions dimensions = gameBoard.getBoardDimensions();
        int boardSize = dimensions.getWidth() * dimensions.getHeight();

        if (index < 0 || index >= boardSize) {
            return ValidationState.OUT_OF_BOUNDS;
        } else if (gameBoard.getCharacterAt(index) != PlayerCharacter.NONE) {
            return ValidationState.OCCUPIED;
        }

        return ValidationState.VALID;
    }
}