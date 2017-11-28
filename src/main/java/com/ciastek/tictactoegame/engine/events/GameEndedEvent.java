package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class GameEndedEvent implements GameEvent {
    private String gameResultMessage;
    private ResourceBundle resourceBundle;


    public GameEndedEvent(ResourceBundle resourceBundle, String gameResultMessage){
        this.resourceBundle = resourceBundle;
        this.gameResultMessage = gameResultMessage;
    }

    @Override
    public String getMessage() {
        String message = resourceBundle.getString("gameOverMessage");
        return String.format(message, gameResultMessage);
    }
}