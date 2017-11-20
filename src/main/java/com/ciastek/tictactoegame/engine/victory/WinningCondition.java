package com.ciastek.tictactoegame.engine.victory;

public class WinningCondition {
    private int winCondition;

    public WinningCondition(int winCondition) {
        this.winCondition = winCondition;
    }

    public int asInt() {
        return winCondition;
    }
}
