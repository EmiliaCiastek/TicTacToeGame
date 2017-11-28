package com.ciastek.tictactoegame.engine.events;

import java.util.ResourceBundle;

public class WinningConditionEvent implements GameEvent {
    private int maxWinningCondition;
    private final ResourceBundle resourceBundle;


    public WinningConditionEvent(int maxWinningConditionValue, String filename) {
        this.maxWinningCondition = maxWinningConditionValue;
        resourceBundle = ResourceBundle.getBundle(filename);
    }

    @Override
    public String getMessage() {
        return String.format(resourceBundle.getString("provideWinningConditionMessage"), maxWinningCondition);
    }
}
