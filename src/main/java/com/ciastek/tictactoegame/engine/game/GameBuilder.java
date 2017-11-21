package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;

public class GameBuilder {
    BoardDimensions boardDimensions;
    WinningCondition winningCondition;
    private PlayerCharacter firstPlayer;

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
        return new Game(new GameSettings(boardDimensions, winningCondition, firstPlayer));
    }

    public GameBuilder withFirstPlayer(PlayerCharacter firstPlayer) {
        this.firstPlayer = firstPlayer;

        return this;
    }

    public PlayerCharacter getFirstPlayer() {
        return firstPlayer;
    }
}
