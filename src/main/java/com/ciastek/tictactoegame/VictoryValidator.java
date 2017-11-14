package com.ciastek.tictactoegame;

import java.util.Arrays;
import java.util.List;

public class VictoryValidator {
    private int winningCondition;

    public VictoryValidator(int winningCondition){
        this.winningCondition = winningCondition;
    }

    public boolean isVictory(List<PlayerCharacter> boardPiece){

        // currentCanditate = List.get(0)
        // for i = 1 po  List {
        // if list.get(i) == currentCandidate
        // counter ++
        //     if counter == winningCond return true;
        // else {
        //         curreCa = list get(i)
        //          counter = 0;
        // }
        PlayerCharacter currentCandidate = boardPiece.get(0);
        int counter = 1;

        for (int i = 1; i < boardPiece.size(); i++) {
            if (boardPiece.get(i) == currentCandidate){
                counter ++;
                if (counter == winningCondition && currentCandidate != PlayerCharacter.NONE){
                    return true;
                }
            } else {
                currentCandidate = boardPiece.get(i);
                counter = 1;
            }
        }

        return false;
    }
}
