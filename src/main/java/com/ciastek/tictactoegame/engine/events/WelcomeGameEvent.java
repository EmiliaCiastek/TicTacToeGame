package com.ciastek.tictactoegame.engine.events;

public class WelcomeGameEvent implements GameEvent {
    private final String WELCOME_GAME_EVENT = "Welcome in TicTacToeGame";

    @Override
    public String getMessage() {
        return WELCOME_GAME_EVENT;
    }
}
