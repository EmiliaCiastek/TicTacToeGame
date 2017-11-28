package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;

public class BoardDimensionsResult implements Result<BoardDimensions>{

    private BoardDimensions parsedDimensions;
    private ResultState resultState;


    public BoardDimensionsResult (ResultState resultState, BoardDimensions parsedDimensions){
        this.resultState = resultState;
        this.parsedDimensions = parsedDimensions;
    }

    public  BoardDimensionsResult(ResultState resultState){
        this.resultState = resultState;
    }

    @Override
    public ResultState getResultState() {
        return resultState;
    }

    public BoardDimensions getParsedResult(){
        return parsedDimensions;
    }
}
