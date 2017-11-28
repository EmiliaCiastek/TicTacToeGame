package com.ciastek.tictactoegame.engine.events;

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
