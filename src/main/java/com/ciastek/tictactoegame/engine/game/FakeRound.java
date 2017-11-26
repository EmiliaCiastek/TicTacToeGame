package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.RoundResult;

public class FakeRound implements Round {
    @Override
    public RoundResult play(int index) {
        return new RoundResult(true, new Player(PlayerCharacter.X));
    }

    @Override
    public PlayerCharacter getCurrentPlayer() {
        return PlayerCharacter.X;
    }

    @Override
    public String getBoardAsString() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
