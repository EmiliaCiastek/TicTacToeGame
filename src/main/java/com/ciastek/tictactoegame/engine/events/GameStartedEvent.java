package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class GameStartedEvent implements GameEvent {
    private ResourceBundle resourceBundle;

    public GameStartedEvent(String filename){
        resourceBundle = ResourceBundle.getBundle(filename);
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("gameStartedMessage");
    }
}
