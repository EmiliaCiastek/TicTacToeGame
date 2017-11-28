package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.events.GameEvent;

public class BoardDimensionsEvent implements GameEvent {
    private final String BOARD_DIMENSIONS_MESSAGE = "Provide board size in format: width x height (without spaces). Minimum size 3x3, maximum size 100x100";

    @Override
    public String getMessage() {
        return BOARD_DIMENSIONS_MESSAGE;
    }
}
