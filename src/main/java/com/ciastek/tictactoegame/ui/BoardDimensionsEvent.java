package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.events.GameEvent;

import java.util.ResourceBundle;

public class BoardDimensionsEvent implements GameEvent {
    private final ResourceBundle resourceBundle;

    public BoardDimensionsEvent(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("provideBoardDimensionsMessage");
    }
}
