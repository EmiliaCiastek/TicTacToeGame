package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;

public class GameSettings {
    private WinningCondition winningCondition;
    private BoardDimensions boardDimensions;
    private Player firstPlayer;
    private Player secondPlayer;

    public GameSettings(BoardDimensions boardDimensions, WinningCondition winningCondition, Player firstPlayer, Player secondPlayer){
        this.boardDimensions = boardDimensions;
        this.winningCondition = winningCondition;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public WinningCondition getWinningCondition() {
        return winningCondition;
    }

    public BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }
}
