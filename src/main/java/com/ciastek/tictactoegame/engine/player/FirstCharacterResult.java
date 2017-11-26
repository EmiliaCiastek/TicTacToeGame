package com.ciastek.tictactoegame.engine.player;

import com.ciastek.tictactoegame.Result;

public class FirstCharacterResult implements Result<PlayerCharacter> {

    private PlayerCharacter parsedPlayer;
    private boolean isValid;

    public FirstCharacterResult(boolean isValid, PlayerCharacter parsedPlayer) {
        this.isValid = isValid;
        this.parsedPlayer = parsedPlayer;
    }

    public FirstCharacterResult(){
        this.isValid = false;
        this.parsedPlayer = PlayerCharacter.NONE;
    }

    public PlayerCharacter getParsedResult() {
        return parsedPlayer;
    }

    public boolean isValid() {
        return isValid;
    }
}
