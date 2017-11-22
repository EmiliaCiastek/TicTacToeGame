package com.ciastek.tictactoegame.engine.board;

import com.ciastek.tictactoegame.Result;

public class BoardDimensionsResult extends Result<BoardDimensions>{

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

    public BoardDimensions getParsedDimensions(){
        return parsedDimensions;
    }

    public boolean isValid(){
        return isValid;
    }
}
