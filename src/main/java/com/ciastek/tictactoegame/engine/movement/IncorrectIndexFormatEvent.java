package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.events.GameEvent;

import java.util.ResourceBundle;

public class IncorrectIndexFormatEvent implements GameEvent {
    private final ResourceBundle resourceBundle;

    public IncorrectIndexFormatEvent(String filename) {
        resourceBundle = ResourceBundle.getBundle(filename);
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("incorrectIndexFormatMessage");
    }
}
