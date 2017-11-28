package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class RoundEndedWithDrawEvent implements GameEvent {
    private ResourceBundle resourceBundle;

    public RoundEndedWithDrawEvent(String filename){
        resourceBundle = ResourceBundle.getBundle(filename);
   }

    @Override
    public String getMessage() {
        return resourceBundle.getString("roundEndedWithDrawMessage");
    }
}
