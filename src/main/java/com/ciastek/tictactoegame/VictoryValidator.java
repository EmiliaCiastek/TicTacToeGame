package com.ciastek.tictactoegame;

import java.util.List;

public class VictoryValidator {
    private WinningCondition winningCondition;

    public VictoryValidator(WinningCondition winningCondition){
        this.winningCondition = winningCondition;
    }

    public boolean isVictory(List<PlayerCharacter> boardPiece){

        if(boardPiece.size() < winningCondition.asInt()){
            return false;
        }

        PlayerCharacter currentCandidate = boardPiece.get(0);
        int counter = 1;

        for (int i = 1; i < boardPiece.size(); i++) {
            if (boardPiece.get(i) == currentCandidate){
                counter ++;
                if (counter == winningCondition.asInt() && currentCandidate != PlayerCharacter.NONE){
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
