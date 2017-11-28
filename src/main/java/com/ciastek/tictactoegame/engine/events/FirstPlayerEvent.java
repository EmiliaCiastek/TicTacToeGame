package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class FirstPlayerEvent implements GameEvent {
    private ResourceBundle resourceBundle;

    public FirstPlayerEvent(ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("provideFirstPlayerMessage");
    }
}
