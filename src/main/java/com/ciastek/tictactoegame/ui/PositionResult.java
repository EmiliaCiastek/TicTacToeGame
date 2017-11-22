package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.Result;
import com.ciastek.tictactoegame.engine.movement.Position;

public class PositionResult extends Result<Position> {
    private boolean valid;
    private Position parsedPosition;


    public PositionResult(boolean isValid, Position parsedPosition) {
        this.isValid = isValid;
        this.parsedPosition = parsedPosition;
    }

    public PositionResult(){
        this.isValid = false;
        this.parsedPosition = new Position(-1);
    }

    public Position getParsedPosition() {
        return parsedPosition;
    }
    public boolean isValid() {
        return valid;
    }


}
