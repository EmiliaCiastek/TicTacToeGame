package com.ciastek.tictactoegame.engine.events;

public class RoundStartedEvent implements GameEvent {
    private final String ROUND_STARTED_MESSAGE = "Round number %d started!";
    private int roundNumber;

    public RoundStartedEvent(int roundNumber){
        this.roundNumber = roundNumber;
    }

    @Override
    public String getMessage() {
        return String.format(ROUND_STARTED_MESSAGE, roundNumber);
    }
}
