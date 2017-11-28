package com.ciastek.tictactoegame.engine.events;

public class WelcomeGameEvent implements GameEvent {
    private final String WELCOME_GAME_EVENT = "Welcome in TicTacToeGame. / Witaj w grze kółko/krzyżyk\n" +
            "Aby wybrać polski wpisz: PL / To choose English enter EN";

    @Override
    public String getMessage() {
        return WELCOME_GAME_EVENT;
    }
}