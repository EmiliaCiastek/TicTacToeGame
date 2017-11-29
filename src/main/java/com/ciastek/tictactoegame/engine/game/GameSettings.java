package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;

class GameSettings {
    private WinningCondition winningCondition;
    private BoardDimensions boardDimensions;
    private Player firstPlayer;
    private Player secondPlayer;

    GameSettings(BoardDimensions boardDimensions, WinningCondition winningCondition, Player firstPlayer, Player secondPlayer) {
        this.boardDimensions = boardDimensions;
        this.winningCondition = winningCondition;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    WinningCondition getWinningCondition() {
        return winningCondition;
    }

    public BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }

    Player getFirstPlayer() {
        return firstPlayer;
    }

    Player getSecondPlayer() {
        return secondPlayer;
    }
}