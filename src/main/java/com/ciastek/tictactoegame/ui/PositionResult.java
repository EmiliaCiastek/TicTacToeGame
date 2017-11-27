package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.Result;
import com.ciastek.tictactoegame.engine.movement.Position;

public class PositionResult implements Result<Position> {
    private final boolean isValid;
    private Position parsedPosition;
    private boolean isQuit;


    public PositionResult(boolean isValid, Position parsedPosition) {
        this.isValid = isValid;
        this.parsedPosition = parsedPosition;
    }

    public PositionResult(boolean isQuit){
        this.isQuit = isQuit;
        this.parsedPosition = new Position(-1);
        isValid = false;
    }

    public PositionResult(){
        this.isValid = false;
        this.parsedPosition = new Position(-1);
    }

    public Position getParsedResult() {
        return parsedPosition;
    }
    public boolean isValid() {
        return isValid;
    }

    @Override
    public boolean isQuit() {
        return false;
    }


}
