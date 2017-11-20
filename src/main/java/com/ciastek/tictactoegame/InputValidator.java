package com.ciastek.tictactoegame;

public class InputValidator {

    public PlayerResult checkPlayer(String input) {

        if(input.equals("O") || input.equals("X")){
            return new PlayerResult(true, PlayerCharacter.valueOf(input));
        } else {
            return new PlayerResult();
        }
    }

    public WinningConditionResult checkWinningCondition(String input, BoardDimensions dimensions) {
        try {
            int winningConditionValue = Integer.parseInt(input);

            if(winningConditionValue < 3){
                return new WinningConditionResult();
            } else if (winningConditionValue > dimensions.getWidth() || winningConditionValue > dimensions.getHeight()){
                return new WinningConditionResult();
            } else {
                return new WinningConditionResult(true, new WinningCondition(winningConditionValue));
            }
        } catch (NumberFormatException exception){
            return new WinningConditionResult();
        }
    }
}
