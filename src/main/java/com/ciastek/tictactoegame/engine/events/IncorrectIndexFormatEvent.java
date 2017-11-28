package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class IncorrectIndexFormatEvent implements GameEvent { // Todo: occupied filed event
    private final ResourceBundle resourceBundle;

    public IncorrectIndexFormatEvent(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        return resourceBundle.getString("incorrectIndexFormatMessage");
    }
}