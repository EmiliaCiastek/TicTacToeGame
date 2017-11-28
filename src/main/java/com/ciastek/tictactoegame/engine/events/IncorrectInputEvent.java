package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class IncorrectInputEvent implements GameEvent {
    private ResourceBundle resourceBundle;

    public IncorrectInputEvent(ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("incorrectInputMessage");
    }
}
