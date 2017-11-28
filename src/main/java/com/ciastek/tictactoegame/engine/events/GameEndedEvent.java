package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class GameEndedEvent implements GameEvent {
    private String gameResultMessage;
    private ResourceBundle resourceBundle;


    public GameEndedEvent(String gameResultMessage, String fileName){
        this.resourceBundle = ResourceBundle.getBundle(fileName);
        this.gameResultMessage = gameResultMessage;
    }

    @Override
    public String getMessage() {
        String message = resourceBundle.getString("gameOverMessage");
        return String.format(message, gameResultMessage);
    }
}