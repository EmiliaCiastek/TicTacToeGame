package com.ciastek.tictactoegame.engine.game;

public class GameRoundFactory implements RoundFactory {
    @Override
    public Round getRound(GameSettings gameSettings) {
        return new GameRound(gameSettings);
    }
}
