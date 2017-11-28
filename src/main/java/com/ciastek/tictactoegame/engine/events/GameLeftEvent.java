package com.ciastek.tictactoegame.engine.events;

import com.ciastek.tictactoegame.engine.events.GameEvent;

import java.util.ResourceBundle;

public class GameLeftEvent implements GameEvent {
    private ResourceBundle resourceBundle;

    public GameLeftEvent(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("gameLeftMessage");
    }
}
