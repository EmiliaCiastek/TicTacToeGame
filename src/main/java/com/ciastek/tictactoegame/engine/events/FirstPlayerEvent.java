package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class FirstPlayerEvent implements GameEvent {
    private ResourceBundle resourceBundle;


    public FirstPlayerEvent(String filename){
        resourceBundle = ResourceBundle.getBundle(filename);
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("provideFirstPlayerMessage");
    }
}
