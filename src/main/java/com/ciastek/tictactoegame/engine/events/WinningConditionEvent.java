package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class WinningConditionEvent implements GameEvent {
    private int maxWinningCondition;
    private final ResourceBundle resourceBundle;


    public WinningConditionEvent(ResourceBundle resourceBundle, int maxWinningConditionValue) {
        this.maxWinningCondition = maxWinningConditionValue;
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        return String.format(resourceBundle.getString("provideWinningConditionMessage"), maxWinningCondition);
    }
}