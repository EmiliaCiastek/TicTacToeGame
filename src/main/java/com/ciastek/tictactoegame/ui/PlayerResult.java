package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.player.Player;

public class PlayerResult implements Result<Player>{
    private Player parsedPlayer;
    private boolean isValid;

    public PlayerResult(boolean isValid, Player parsedPlayer) {
        this.isValid = isValid;
        this.parsedPlayer = parsedPlayer;
    }

    public PlayerResult(){
        this.isValid = false;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }

    @Override
    public Player getParsedResult() {
        return parsedPlayer;
    }
}
