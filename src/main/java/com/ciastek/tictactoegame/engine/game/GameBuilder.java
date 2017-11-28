package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.movement.PositionInput;
import com.ciastek.tictactoegame.engine.movement.PositionScannerInput;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.ui.InputReader;
import com.ciastek.tictactoegame.ui.Printer;

public class GameBuilder {
    private BoardDimensions boardDimensions;
    private WinningCondition winningCondition;
    private Player firstPlayer;
    private Player secondPlayer;
    private Observer gameObserver;
    private Player oPlayer;
    private Player xPlayer;
    private InputReader inputReader;
    private String languageFile;
    private PositionInput positionInput;

    public GameBuilder withBoardDimensions(BoardDimensions dimensions){
        this.boardDimensions = dimensions;

        return this;
    }

    public BoardDimensions getBoardDimensions() {
        return boardDimensions;
    }

    public GameBuilder withLanguageFile(String languageFile){
        this.languageFile = languageFile;

        return this;
    }

    public GameBuilder withWinningCondition(WinningCondition winningCondition) {
        this.winningCondition = winningCondition;

        return this;
    }

    public GameBuilder withObserver(Observer observer){
        this.gameObserver = observer;
        return this;
    }

    public GameBuilder withPositionInput(PositionInput positionInput){
        this.positionInput = positionInput;
        return this;
    }

    public WinningCondition getWinningCondition() {
        return winningCondition;
    }


    public Game build() {
        GameSettings settings = new GameSettings(boardDimensions, winningCondition, firstPlayer, secondPlayer
        );
        Game game = new Game(settings, new GameRoundFactory(), positionInput, languageFile);
        game.registerObserver(gameObserver);
        return game;
    }

    public GameBuilder withFirstPlayer(PlayerCharacter firstPlayerCharacter) {
        switch (firstPlayerCharacter){
            case X:
                firstPlayer = xPlayer;
                secondPlayer = oPlayer;
                break;
            case O:
                firstPlayer = oPlayer;
                secondPlayer = xPlayer;
                break;
        }

        return this;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public GameBuilder withPlayers(Player oPlayer, Player xPlayer) {
        this.oPlayer = oPlayer;
        this.xPlayer = xPlayer;
        return this;
    }
}
