package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;

public class GameSettings {
    private final int DEFULT_BOARD_SIZE = 3;
    private final int DEFAULT_WINNING_CONDITION_VALUE = 3;
    private WinningCondition winningCondition;
    private BoardDimensions boardDimensions;

    public GameSettings(){
        this.boardDimensions = new BoardDimensions(DEFULT_BOARD_SIZE, DEFULT_BOARD_SIZE);
        this.winningCondition = new WinningCondition(DEFAULT_WINNING_CONDITION_VALUE);
    }

    public GameSettings(BoardDimensions boardDimensions, WinningCondition winningCondition){
        this.boardDimensions = boardDimensions;
        this.winningCondition = winningCondition;
    }

    public WinningCondition getWinningCondition() {
        return winningCondition;
    }

    public BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }

}
