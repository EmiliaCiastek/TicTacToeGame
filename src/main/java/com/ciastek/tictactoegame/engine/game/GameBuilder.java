package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;

public class GameBuilder {
    BoardDimensions boardDimensions;
    WinningCondition winningCondition;

    public GameBuilder withBoardDimensions(BoardDimensions dimensions){
        this.boardDimensions = dimensions;

        return this;
    }

    public BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }

    public GameBuilder withWinningCondition(WinningCondition winningCondition) {
        this.winningCondition = winningCondition;

        return this;
    }

    public WinningCondition getWinningCondition() {
        return winningCondition;
    }


    public Game build() {
        return new Game(new GameSettings(boardDimensions, winningCondition));
    }
}
