package com.ciastek.tictactoegame;

public class HorizontalVictoryValidator {
    private int winningCondition;

    public HorizontalVictoryValidator(int winningCondition){
        this.winningCondition = winningCondition;
    }

    public boolean isVictory(String row) {
        long xCounter = row.chars().filter(ch -> ch =='X').count();
        long oCounter = row.chars().filter(ch -> ch =='O').count();

        return xCounter == winningCondition || oCounter == winningCondition;
    }
}
