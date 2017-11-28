package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.events.GameEvent;

import java.util.ResourceBundle;

public class BoardDimensionsEvent implements GameEvent {
    private final ResourceBundle resourceBundle;

    public BoardDimensionsEvent(String filename) {
        resourceBundle = ResourceBundle.getBundle(filename);
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("provideBoardDimensionsMessage");
    }
}
