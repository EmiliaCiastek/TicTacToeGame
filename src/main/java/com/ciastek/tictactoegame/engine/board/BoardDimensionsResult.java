package com.ciastek.tictactoegame.engine.board;

import com.ciastek.tictactoegame.Result;

public class BoardDimensionsResult implements Result<BoardDimensions>{

    private BoardDimensions parsedDimensions;
    private boolean isValid;

    public BoardDimensionsResult (boolean isValid, BoardDimensions parsedDimensions){
        this.isValid = isValid;
        this.parsedDimensions = parsedDimensions;
    }

    public  BoardDimensionsResult(){
        this.isValid = false;
        this.parsedDimensions = null;
    }

    public BoardDimensions getParsedResult(){
        return parsedDimensions;
    }

    public boolean isValid(){
        return isValid;
    }

    @Override
    public boolean isQuit() {
        return false;
    }
}
