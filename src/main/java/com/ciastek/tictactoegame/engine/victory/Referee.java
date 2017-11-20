package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

import java.util.List;

public class Referee {

    private WinningCondition winningCondition;
    private BoardSplitter splitter;
    private VictoryValidator validator;

    public Referee(WinningCondition winningCondition) {
        this.winningCondition = winningCondition;
        this.splitter = new BoardSplitter();
        this.validator = new VictoryValidator(winningCondition);
    }

    public boolean isWon(Board board, int index) {
        List<PlayerCharacter> column = splitter.getColumn(board, index);
        List<PlayerCharacter> row = splitter.getRow(board, index);
        List<PlayerCharacter> topLeftDiagonal = splitter.getTopLeftBottomRightDiagonal(board, index);
        List<PlayerCharacter> topRightDiagonal = splitter.getTopRightBottomLeftDiagonal(board, index);

        boolean isVictory = validator.isVictory(column) ||
                validator.isVictory(row) ||
                validator.isVictory(topLeftDiagonal) ||
                validator.isVictory(topRightDiagonal);

        return isVictory;

    }
}
