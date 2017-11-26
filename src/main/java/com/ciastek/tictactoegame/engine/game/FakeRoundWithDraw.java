package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.RoundResult;

public class FakeRoundWithDraw implements Round {
    private boolean isFinished;

    @Override
    public RoundResult play(int index) {
        return new RoundResult();
    }

    @Override
    public Player getCurrentPlayer() {
        return new Player(PlayerCharacter.X);
    }

    @Override
    public String getBoardAsString() {
        return null;
    }

    @Override
    public boolean isFinished() {
        boolean result = isFinished;
        isFinished = !isFinished;
        return result;
    }
}
