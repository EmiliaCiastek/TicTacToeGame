package com.ciastek.tictactoegame;

import java.util.List;

public class Referee {

    private int winningCondition;

    //TODO:
    //1) Use BoardSplitter
    //2) Then VictoryValidator x4

    public Referee(int winningCondition) {
        this.winningCondition = winningCondition;
    }

    public boolean isWon(List<PlayerCharacter> boardPiece) {

        return false;
    }
}
