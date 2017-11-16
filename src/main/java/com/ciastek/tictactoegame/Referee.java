package com.ciastek.tictactoegame;

import java.util.List;

public class Referee {

    private int winningCondition;
    private BoardSplitter splitter;
    private VictoryValidator validator;

    public Referee(int winningCondition) {
        this.winningCondition = winningCondition;
        this.splitter = new BoardSplitter();
        this.validator = new VictoryValidator(winningCondition);
    }

    public boolean isWon(Board board, int index) {
        List<PlayerCharacter> column = splitter.getColumn(board, index);
        List<PlayerCharacter> row = splitter.getRow(board, index);




        boolean isVictory = validator.isVictory(column) ||
                validator.isVictory(row);



        return isVictory;

    }
}
