package com.ciastek.tictactoegame;

public class WinningConditionResult {
    private WinningCondition parsedValue;
    private boolean isValid;

    public WinningConditionResult(boolean isValid, WinningCondition parsedValue){
        this.isValid = isValid;
        this.parsedValue = parsedValue;
    }

    public WinningConditionResult(){
        this.isValid = false;
        this.parsedValue = new WinningCondition(0);
    }

    public WinningCondition getParsedValue() {
        return parsedValue;
    }

    public boolean isValid() {
        return isValid;
    }
}
