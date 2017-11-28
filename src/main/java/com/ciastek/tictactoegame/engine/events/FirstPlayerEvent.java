package com.ciastek.tictactoegame.engine.events;

public class FirstPlayerEvent implements GameEvent {
    private final String FIRST_PLAYER_MESSAGE = "Choose first player: O or X?";

    @Override
    public String getMessage() {
        return FIRST_PLAYER_MESSAGE;
    }
}
