package com.ciastek.tictactoegame.engine.events;

public class WelcomeGameEvent implements GameEvent {
    private final String WELCOME_GAME_EVENT = "Welcome in TicTacToeGame. / Witaj w grze kółko/krzyżyk\n" +
            "To choose English enter: EN / Aby wybrać polski wpisz: PL";

    @Override
    public String getMessage() {
        return WELCOME_GAME_EVENT;
    }
}