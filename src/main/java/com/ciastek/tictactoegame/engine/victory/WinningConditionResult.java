package com.ciastek.tictactoegame.engine.victory;

import com.ciastek.tictactoegame.ui.Result;
import com.ciastek.tictactoegame.ui.ResultState;

public class WinningConditionResult implements Result<WinningCondition> {
    private WinningCondition parsedValue;
    private ResultState resultState;

    public WinningConditionResult(ResultState resultState, WinningCondition parsedValue) {
        this.resultState = resultState;
        this.parsedValue = parsedValue;
    }

    public WinningConditionResult(ResultState resultState) {
        this.resultState = resultState;
    }

    @Override
    public WinningCondition getParsedResult() {
        return parsedValue;
    }

    @Override
    public ResultState getResultState() {
        return resultState;
    }
}