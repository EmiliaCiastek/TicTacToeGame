package com.ciastek.tictactoegame;

public class PlayerResult extends Result<PlayerCharacter> {

    private PlayerCharacter parsedPlayer;
    private boolean isValid;

    public PlayerResult(boolean isValid, String input) {
        this.isValid = isValid;

        this.parsedPlayer = parseInput(isValid, input);
    }

    public PlayerCharacter getParsedPlayer() {
        return parsedPlayer;
    }

    private PlayerCharacter parseInput(boolean isValid, String input) {
        if(isValid){
            return PlayerCharacter.valueOf(input);
        } else {
            return PlayerCharacter.NONE;
        }
    }
}
