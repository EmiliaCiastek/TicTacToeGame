package com.ciastek.tictactoegame.engine.events;

public class GameEndedEvent implements GameEvent {
    private final String GAME_OVER_MESSAGE = "Game over!";
    private String gameResultMessage;

    public GameEndedEvent(String gameResultMessage){
        this.gameResultMessage = gameResultMessage;
    }

    @Override
    public String getMessage() {
        return GAME_OVER_MESSAGE + "\n" + gameResultMessage;
    }
}