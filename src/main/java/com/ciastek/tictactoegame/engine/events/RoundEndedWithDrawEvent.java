package com.ciastek.tictactoegame.engine.events;

public class RoundEndedWithDrawEvent implements GameEvent {
    private final String ROUND_DRAW_MESSAGE = "Round over with draw!";

    @Override
    public String getMessage() {
        return ROUND_DRAW_MESSAGE;
    }
}
