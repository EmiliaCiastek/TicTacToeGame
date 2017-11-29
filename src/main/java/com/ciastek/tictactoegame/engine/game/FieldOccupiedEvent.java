package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.events.GameEvent;

import java.util.ResourceBundle;

public class FieldOccupiedEvent implements GameEvent {
    private ResourceBundle resourceBundle;

    public FieldOccupiedEvent(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("fieldOccupiedMessage");
    }
}