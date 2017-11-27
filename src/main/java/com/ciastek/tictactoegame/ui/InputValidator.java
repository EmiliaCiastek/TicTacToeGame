package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.board.BoardDimensionsResult;
import com.ciastek.tictactoegame.engine.movement.Position;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.player.FirstCharacterResult;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.victory.WinningConditionResult;

public class InputValidator {
    private final int MAX_BOARD_SIZE = 100;
    private final int MIN_BOARD_SIZE = 3;

    public FirstCharacterResult checkPlayer(String input) {

        if(input.equalsIgnoreCase("O") || input.equalsIgnoreCase("X")){
            return new FirstCharacterResult(true, PlayerCharacter.valueOf(input.toUpperCase()));
        } else {
            return new FirstCharacterResult();
        }
    }

    public WinningConditionResult checkWinningCondition(String input, BoardDimensions dimensions) {
        try {
            int winningConditionValue = Integer.parseInt(input);

            if(winningConditionValue < MIN_BOARD_SIZE || winningConditionValue > Math.min(dimensions.getHeight(), dimensions.getWidth())){
                return new WinningConditionResult();
            } else {
                return new WinningConditionResult(true, new WinningCondition(winningConditionValue));
            }
        } catch (NumberFormatException exception){
            return new WinningConditionResult();
        }
    }

    public BoardDimensionsResult checkBoardDimensions(String input) {
        if(input.matches("(\\d+)x(\\d+)")){
            int width = Integer.parseInt(input.split("x")[0]);
            int height = Integer.parseInt(input.split("x")[1]);
            if(width > MAX_BOARD_SIZE || height > MAX_BOARD_SIZE || width < MIN_BOARD_SIZE || height < MIN_BOARD_SIZE){
                return new BoardDimensionsResult();
            }
            return new BoardDimensionsResult(true, new BoardDimensions(width, height));
        }

        return new BoardDimensionsResult();
    }

    public PositionResult checkPosition(String input) {

        try {
            int index = Integer.parseInt(input);
            return new PositionResult(true, new Position(index));
        } catch (NumberFormatException exception){
            return new PositionResult();
        }
    }

    public PlayerResult checkPlayerName(String input, PlayerCharacter playerCharacter) {
        if (!input.matches("[a-zA-Z]+")){
            return new PlayerResult();
        }

        return new PlayerResult(true, new Player(playerCharacter, input));
    }
}