package com.ciastek.tictactoegame;

public class PlayerResult extends Result<PlayerCharacter> {

    private PlayerCharacter parsedPlayer;
    private boolean isValid;

    public PlayerResult(boolean isValid, PlayerCharacter parsedPlayer) {
        this.isValid = isValid;
        this.parsedPlayer = parsedPlayer;
    }

    public PlayerResult(){
        this.isValid = false;
        this.parsedPlayer = PlayerCharacter.NONE;
    }

    public PlayerCharacter getParsedPlayer() {
        return parsedPlayer;
    }

    public boolean isValid() {
        return isValid;
    }
}
