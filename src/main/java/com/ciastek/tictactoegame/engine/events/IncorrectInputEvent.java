package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class IncorrectInputEvent implements GameEvent {
    private ResourceBundle resourceBundle;

    public IncorrectInputEvent(String filename){
        resourceBundle = ResourceBundle.getBundle(filename);
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("incorrectInputMessage");
    }
}
