package com.ciastek.tictactoegame.engine.events;

public class GameStartedEvent implements GameEvent {
    private final String GAME_STARTED_MESSAGE = "Game started";

    @Override
    public String getMessage() {
        return GAME_STARTED_MESSAGE;
    }
}
