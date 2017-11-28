package com.ciastek.tictactoegame.engine.events;

public class WinningConditionEvent implements GameEvent {
    private final String WINING_CONDITION_MESSAGE = "Provide winning condition: greater than 2 and smaller or equal %s";
    private int maxWinningCondition;

    public WinningConditionEvent(int maxWinningConditionValue) {
        this.maxWinningCondition = maxWinningConditionValue;
    }

    @Override
    public String getMessage() {
        return String.format(WINING_CONDITION_MESSAGE, maxWinningCondition);
    }
}
