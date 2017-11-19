package com.ciastek.tictactoegame;

public class InputValidator {
    public boolean isValid(String input) {
        return false;
    }

    public PlayerResult checkPlayer(String input) {

        if(input.equals("O") || input.equals("X")){
            return new PlayerResult(true, input);
        } else {
            return new PlayerResult(false, input);
        }
    }
}
