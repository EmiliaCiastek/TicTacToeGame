package com.ciastek.tictactoegame;

public class VictoryValidator {
    private int winningCondition;

    public VictoryValidator(int winningCondition){
        this.winningCondition = winningCondition;
    }

    public boolean isVictory(String boardPiece){
        long xCounter = boardPiece.chars().filter(ch -> ch =='X').count();
        long oCounter = boardPiece.chars().filter(ch -> ch =='O').count();

        return xCounter == winningCondition || oCounter == winningCondition;
    }
}
