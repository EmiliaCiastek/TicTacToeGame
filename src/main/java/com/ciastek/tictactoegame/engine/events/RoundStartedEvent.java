package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class RoundStartedEvent implements GameEvent {
    private int roundNumber;
    private final ResourceBundle resourceBundle;

    public RoundStartedEvent(ResourceBundle resourceBundle, int roundNumber){
        this.resourceBundle = resourceBundle;
        this.roundNumber = roundNumber;
    }

    @Override
    public String getMessage() {
        return String.format(resourceBundle.getString("roundStartedMessage"), roundNumber);
    }
}