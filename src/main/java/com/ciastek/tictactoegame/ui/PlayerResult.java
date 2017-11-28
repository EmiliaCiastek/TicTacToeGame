package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.player.Player;

public class PlayerResult implements Result<Player>{
    private Player parsedPlayer;
    private ResultState resultState;

    public PlayerResult(ResultState resultState, Player parsedPlayer) {
        this.parsedPlayer = parsedPlayer;
        this.resultState = resultState;
    }

    public PlayerResult(ResultState resultState){
        this.resultState = resultState;
    }

    @Override
    public ResultState getResultState() {
        return resultState;
    }

    @Override
    public Player getParsedResult() {
        return parsedPlayer;
    }
}
