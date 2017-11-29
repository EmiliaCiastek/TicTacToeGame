package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.movement.Position;
import com.ciastek.tictactoegame.engine.player.FirstCharacterResult;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.victory.WinningConditionResult;

class InputValidator {
    private final int MAX_BOARD_SIZE = 100;
    private final int MIN_BOARD_SIZE = 3;

    FirstCharacterResult checkPlayer(String input) {

        if (input.equalsIgnoreCase("O") || input.equalsIgnoreCase("X")) {
            return new FirstCharacterResult(ResultState.VALID, PlayerCharacter.valueOf(input.toUpperCase()));
        } else {
            return new FirstCharacterResult(ResultState.INVALID);
        }
    }

    WinningConditionResult checkWinningCondition(String input, BoardDimensions dimensions) {
        try {
            int winningConditionValue = Integer.parseInt(input);

            if (winningConditionValue < MIN_BOARD_SIZE || winningConditionValue > Math.min(dimensions.getHeight(), dimensions.getWidth())) {
                return new WinningConditionResult(ResultState.INVALID);
            } else {
                return new WinningConditionResult(ResultState.VALID, new WinningCondition(winningConditionValue));
            }
        } catch (NumberFormatException exception) {
            return new WinningConditionResult(ResultState.INVALID);
        }
    }

    BoardDimensionsResult checkBoardDimensions(String input) {
        if (input.matches("(\\d+)x(\\d+)")) {
            int width = Integer.parseInt(input.split("x")[0]);
            int height = Integer.parseInt(input.split("x")[1]);
            if (width > MAX_BOARD_SIZE || height > MAX_BOARD_SIZE || width < MIN_BOARD_SIZE || height < MIN_BOARD_SIZE) {
                return new BoardDimensionsResult(ResultState.INVALID);
            }
            return new BoardDimensionsResult(ResultState.VALID, new BoardDimensions(width, height));
        }

        return new BoardDimensionsResult(ResultState.INVALID);
    }

    PositionResult checkPosition(String input) {
        if (input.equalsIgnoreCase("q")) {
            return new PositionResult(ResultState.EXIT);
        }

        try {
            int index = Integer.parseInt(input);
            return new PositionResult(ResultState.VALID, new Position(index));
        } catch (NumberFormatException exception) {
            return new PositionResult(ResultState.INVALID);
        }
    }

    PlayerResult checkPlayerName(String input, PlayerCharacter playerCharacter) {
        if (!input.matches("[a-zA-Z]+")) {
            return new PlayerResult(ResultState.INVALID);
        }

        return new PlayerResult(ResultState.VALID, new Player(playerCharacter, input));
    }
}