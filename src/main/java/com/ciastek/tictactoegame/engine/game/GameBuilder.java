package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.movement.PositionScannerInput;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.ui.Printer;

public class GameBuilder {
    private BoardDimensions boardDimensions;
    private WinningCondition winningCondition;
    private PlayerCharacter firstPlayer;
    private Observer gameObserver;

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

    public GameBuilder withObserver(Observer observer){
        this.gameObserver = observer;
        return this;
    }

    public WinningCondition getWinningCondition() {
        return winningCondition;
    }


    public Game build() {
        Game game = new Game(new GameSettings(boardDimensions, winningCondition, firstPlayer), new GameRoundFactory(), new PositionScannerInput());
        game.registerObserver(gameObserver);
        return game;
    }

    public GameBuilder withFirstPlayer(PlayerCharacter firstPlayer) {
        this.firstPlayer = firstPlayer;

        return this;
    }

    public PlayerCharacter getFirstPlayer() {
        return firstPlayer;
    }
}
