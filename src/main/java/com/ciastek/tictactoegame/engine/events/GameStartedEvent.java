package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class GameStartedEvent implements GameEvent {
    private ResourceBundle resourceBundle;

    public GameStartedEvent(ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
    }


    @Override
    public String getMessage() {
        return resourceBundle.getString("gameStartedMessage");
    }
}
