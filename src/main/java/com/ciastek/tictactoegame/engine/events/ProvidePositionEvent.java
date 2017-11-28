package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class ProvidePositionEvent implements GameEvent {
    private final ResourceBundle resourceBundle;

    public ProvidePositionEvent(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("providePositionMessage");
    }
}
