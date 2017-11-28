package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.board.BoardDimensionsResult;
import com.ciastek.tictactoegame.engine.events.*;
import com.ciastek.tictactoegame.engine.game.Game;
import com.ciastek.tictactoegame.engine.game.GameBuilder;
import com.ciastek.tictactoegame.engine.player.FirstCharacterResult;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.victory.WinningConditionResult;

public class GameUI {
    private static InputReader inputReader;
    private static Printer gamePrinter;

    public static void main(String[] args) {
        //TODO: add quit option
        gamePrinter = new Printer();

        inputReader = new InputReader();

        GameBuilder gameBuilder = new GameBuilder();

        gamePrinter.notify(new WelcomeGameEvent());

        gameBuilder.withPlayers(setPlayer(PlayerCharacter.O), setPlayer(PlayerCharacter.X))
                .withBoardDimensions(setBoardDimensions())
                .withWinningCondition(setWinningCondition(gameBuilder.getBoardDimensions()))
                .withFirstPlayer(setFirstPlayer())
                .withObserver(gamePrinter)
                .withImputReader(inputReader);

        Game game = gameBuilder.build();

        gamePrinter.notify(new GameStartedEvent());

        while (!game.isFinished()) {
            game.play();
        }
    }

    private static Player setPlayer(PlayerCharacter playerCharacter) {
        InputValidator inputValidator = new InputValidator();
        gamePrinter.notify(new PlayerNameEvent(playerCharacter));
        PlayerResult oPlayerResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);

        while (!oPlayerResult.isValid()) {
            gamePrinter.notify(new IncorrectInputEvent());
            gamePrinter.notify(new PlayerNameEvent(playerCharacter));
            oPlayerResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);
        }

        return oPlayerResult.getParsedResult();
    }

    private static PlayerCharacter setFirstPlayer() {
        InputValidator inputValidator = new InputValidator();
        gamePrinter.notify(new FirstPlayerEvent());
        FirstCharacterResult firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());

        while (!firstPlayerResult.isValid()) {
            gamePrinter.notify(new IncorrectInputEvent());
            gamePrinter.notify(new FirstPlayerEvent());
            firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());
        }
        return firstPlayerResult.getParsedResult();
    }

    private static WinningCondition setWinningCondition(BoardDimensions dimensions) {
        InputValidator inputValidator = new InputValidator();
        int maxWinningConditionValue = Math.min(dimensions.getWidth(), dimensions.getHeight());
        gamePrinter.notify(new WinningConditionEvent(maxWinningConditionValue));
        WinningConditionResult winningConditionResult = inputValidator.checkWinningCondition(inputReader.readInput(), dimensions);

        while (!winningConditionResult.isValid()) {
            gamePrinter.notify(new IncorrectInputEvent());
            gamePrinter.notify(new WinningConditionEvent(maxWinningConditionValue));
            winningConditionResult = inputValidator.checkWinningCondition(inputReader.readInput(), dimensions);
        }

        return winningConditionResult.getParsedValue();
    }

    private static BoardDimensions setBoardDimensions() {
        InputValidator inputValidator = new InputValidator();
        gamePrinter.notify(new BoardDimensionsEvent());

        BoardDimensionsResult boardDimensionsResult = inputValidator.checkBoardDimensions(inputReader.readInput());
        while (!boardDimensionsResult.isValid()) {
            gamePrinter.notify(new IncorrectInputEvent());
            gamePrinter.notify(new BoardDimensionsEvent());
            boardDimensionsResult = inputValidator.checkBoardDimensions(inputReader.readInput());
        }

        return boardDimensionsResult.getParsedResult();
    }
}