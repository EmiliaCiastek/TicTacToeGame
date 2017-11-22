package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;

public class GameSettings {
    private final int DEFAULT_BOARD_SIZE = 3;
    private final int DEFAULT_WINNING_CONDITION_VALUE = 3;
    private WinningCondition winningCondition;
    private BoardDimensions boardDimensions;
    private PlayerCharacter firstPlayer;

    public GameSettings(){
        this.boardDimensions = new BoardDimensions(DEFAULT_BOARD_SIZE, DEFAULT_BOARD_SIZE);
        this.winningCondition = new WinningCondition(DEFAULT_WINNING_CONDITION_VALUE);
        this.firstPlayer = PlayerCharacter.O;
    }

    public GameSettings(BoardDimensions boardDimensions, WinningCondition winningCondition){
        this.boardDimensions = boardDimensions;
        this.winningCondition = winningCondition;
    }

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
