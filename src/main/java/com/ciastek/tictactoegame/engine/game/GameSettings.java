package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;

class GameSettings {
    private WinningCondition winningCondition;
    private BoardDimensions boardDimensions;
    private PlayerCharacter firstPlayer;

    public GameSettings(BoardDimensions boardDimensions, WinningCondition winningCondition, PlayerCharacter firstPlayer){
        this.boardDimensions = boardDimensions;
        this.winningCondition = winningCondition;
        this.firstPlayer = firstPlayer;
    }

    public WinningCondition getWinningCondition() {
        return winningCondition;
    }

    public BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }

    public PlayerCharacter getFirstPlayer() {
        return firstPlayer;
    }
}
