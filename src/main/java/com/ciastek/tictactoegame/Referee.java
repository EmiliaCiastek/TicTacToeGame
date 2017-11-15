package com.ciastek.tictactoegame;

import java.util.List;

public class Referee {

    private int winningCondition;
    private BoardSplitter splitter;
    private VictoryValidator validator;

    //TODO:
    //1) Use BoardSplitter
    //2) Then VictoryValidator x4

    public Referee(int winningCondition) {
        this.winningCondition = winningCondition;
        this.splitter = new BoardSplitter();
        this.validator = new VictoryValidator(winningCondition);
    }

    public boolean isWon(Board board, int index) {
        //check column:
        List<PlayerCharacter> column = splitter.getColumn(board, index);
        List<PlayerCharacter> row = splitter.getRow(board, index);
        //List<PlayerCharacter> diagonal1 = splitter.getTopBottomDiagonal(board, index);
        //List<PlayerCharacter> diagonal2 = splitter.getBottomTopDiagonal(board, index);


        boolean isVictory = validator.isVictory(column) ||
                validator.isVictory(row);
                //validator.isVictory(diagonal1);
               // validator.isVictory(diagonal2);

        return isVictory;

    }
}
