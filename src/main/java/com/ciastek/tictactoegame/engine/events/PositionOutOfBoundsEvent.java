package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class PositionOutOfBoundsEvent implements GameEvent {
    private ResourceBundle resourceBundle;

    public PositionOutOfBoundsEvent(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("fieldOutOfBounds");
    }
}