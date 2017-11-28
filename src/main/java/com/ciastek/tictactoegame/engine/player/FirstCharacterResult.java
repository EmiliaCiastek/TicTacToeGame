package com.ciastek.tictactoegame.engine.player;

import com.ciastek.tictactoegame.ui.Result;
import com.ciastek.tictactoegame.ui.ResultState;

public class FirstCharacterResult implements Result<PlayerCharacter> {

    private PlayerCharacter parsedPlayer;
    private ResultState resultState;

    public FirstCharacterResult(ResultState resultState, PlayerCharacter parsedPlayer) {
        this.resultState = resultState;
        this.parsedPlayer = parsedPlayer;
    }

    public FirstCharacterResult(ResultState resultState){
        this.resultState = resultState;
    }

    @Override
    public ResultState getResultState() {
        return resultState;
    }

    public PlayerCharacter getParsedResult() {
        return parsedPlayer;
    }
}