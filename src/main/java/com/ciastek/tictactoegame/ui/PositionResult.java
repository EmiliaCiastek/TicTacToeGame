package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.movement.Position;

public class PositionResult implements Result<Position> {
    private Position parsedPosition;
    private ResultState resultState;

    public PositionResult(ResultState resultState, Position parsedPosition){
        this.resultState = resultState;
        this.parsedPosition = parsedPosition;
    }

    public PositionResult(ResultState resultState){
        this.resultState = resultState;
    }

    public Position getParsedResult() {
        return parsedPosition;
    }

    public ResultState getResultState() {
        return resultState;
    }
}