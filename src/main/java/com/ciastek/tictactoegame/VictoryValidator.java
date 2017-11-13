package com.ciastek.tictactoegame;

import java.util.Arrays;

public class VictoryValidator {
    private int winningCondition;

    public VictoryValidator(int winningCondition){
        this.winningCondition = winningCondition;
    }

    public boolean isVictory(String boardPiece){
        long xCounter = boardPiece.chars().filter(ch -> ch =='X').count();
        long oCounter = boardPiece.chars().filter(ch -> ch =='O').count();

        System.out.println(xCounter);
        System.out.println(oCounter);

        //TODO: regex!

        String joinedString = String.join(" ", "X", "X", "X");
        String joinedString2 = String.join(" ", "O", "O", "O");

        System.out.println(joinedString);
        System.out.println(joinedString2);


        return boardPiece.contains(joinedString) || boardPiece.contains(joinedString2);
    }
}
