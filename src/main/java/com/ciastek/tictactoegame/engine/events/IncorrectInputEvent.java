package com.ciastek.tictactoegame.engine.events;

public class IncorrectInputEvent implements GameEvent {
    private final String INCORRECT_INPUT_MESSAGE = "Provided input is incorrect.";

    @Override
    public String getMessage() {
        return INCORRECT_INPUT_MESSAGE;
    }
}
