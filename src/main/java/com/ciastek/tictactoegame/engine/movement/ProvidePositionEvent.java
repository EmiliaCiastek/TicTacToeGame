package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.events.GameEvent;

import java.util.ResourceBundle;

public class ProvidePositionEvent implements GameEvent {
    private final ResourceBundle resourceBundle;

    public ProvidePositionEvent(String filename) {
        resourceBundle = ResourceBundle.getBundle(filename);
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("providePositionMessage");
    }
}
