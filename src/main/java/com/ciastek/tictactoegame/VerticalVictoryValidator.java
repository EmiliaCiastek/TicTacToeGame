package com.ciastek.tictactoegame;

public class VerticalVictoryValidator implements VictoryValidator{
    private int winningCondition;

    public VerticalVictoryValidator(int winningCondition) {
        this.winningCondition = winningCondition;
    }

    @Override
    public boolean isVictory(String column) {
        long xCounter = column.chars().filter(ch -> ch =='X').count();
        long oCounter = column.chars().filter(ch -> ch =='O').count();

        return xCounter == winningCondition || oCounter == winningCondition;
    }
}
