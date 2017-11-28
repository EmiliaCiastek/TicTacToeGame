package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.board.BoardDimensionsResult;
import com.ciastek.tictactoegame.engine.events.*;
import com.ciastek.tictactoegame.engine.game.Game;
import com.ciastek.tictactoegame.engine.game.GameBuilder;
import com.ciastek.tictactoegame.engine.movement.PositionScannerInput;
import com.ciastek.tictactoegame.engine.player.FirstCharacterResult;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.victory.WinningConditionResult;

public class GameUI {
    private static InputReader inputReader;
    private static Printer gamePrinter;
    private static String languageFile;

    public static void main(String[] args) {
        //TODO: add quit option
        gamePrinter = new Printer();

        inputReader = new InputReader();

        GameBuilder gameBuilder = new GameBuilder();

        gamePrinter.notify(new WelcomeGameEvent());

        languageFile = setLanguage();
        PositionScannerInput positionScannerInput = new PositionScannerInput(inputReader, languageFile, gamePrinter);

        gameBuilder.withPlayers(setPlayer(PlayerCharacter.O), setPlayer(PlayerCharacter.X))
                .withBoardDimensions(setBoardDimensions())
                .withWinningCondition(setWinningCondition(gameBuilder.getBoardDimensions()))
                .withFirstPlayer(setFirstPlayer())
                .withObserver(gamePrinter)
                .withPositionInput(positionScannerInput)
                .withLanguageFile(languageFile);

        Game game = gameBuilder.build();

        gamePrinter.notify(new GameStartedEvent(languageFile));

        while (!game.isFinished()) {
            game.play();
        }
    }

    private static String setLanguage() {
        String languageInput = inputReader.readInput();
        if(languageInput.equalsIgnoreCase("PL")){
            return "Strings_pl";
        }

        return "Strings";
    }

    private static Player setPlayer(PlayerCharacter playerCharacter) {
        InputValidator inputValidator = new InputValidator();
        gamePrinter.notify(new PlayerNameEvent(playerCharacter, languageFile));
        PlayerResult playerNameResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);

        while (!playerNameResult.isValid()) {
            gamePrinter.notify(new IncorrectInputEvent(languageFile));
            gamePrinter.notify(new PlayerNameEvent(playerCharacter, languageFile));
            playerNameResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);
        }

        return playerNameResult.getParsedResult();
    }

    private static PlayerCharacter setFirstPlayer() {
        InputValidator inputValidator = new InputValidator();
        gamePrinter.notify(new FirstPlayerEvent(languageFile));
        FirstCharacterResult firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());

        while (!firstPlayerResult.isValid()) {
            gamePrinter.notify(new IncorrectInputEvent(languageFile));
            gamePrinter.notify(new FirstPlayerEvent(languageFile));
            firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());
        }
        return firstPlayerResult.getParsedResult();
    }

    private static WinningCondition setWinningCondition(BoardDimensions dimensions) {
        InputValidator inputValidator = new InputValidator();
        int maxWinningConditionValue = Math.min(dimensions.getWidth(), dimensions.getHeight());
        gamePrinter.notify(new WinningConditionEvent(maxWinningConditionValue, languageFile));
        WinningConditionResult winningConditionResult = inputValidator.checkWinningCondition(inputReader.readInput(), dimensions);

        while (!winningConditionResult.isValid()) {
            gamePrinter.notify(new IncorrectInputEvent(languageFile));
            gamePrinter.notify(new WinningConditionEvent(maxWinningConditionValue, languageFile));
            winningConditionResult = inputValidator.checkWinningCondition(inputReader.readInput(), dimensions);
        }

        return winningConditionResult.getParsedValue();
    }

    private static BoardDimensions setBoardDimensions() {
        InputValidator inputValidator = new InputValidator();
        gamePrinter.notify(new BoardDimensionsEvent(languageFile));

        BoardDimensionsResult boardDimensionsResult = inputValidator.checkBoardDimensions(inputReader.readInput());
        while (!boardDimensionsResult.isValid()) {
            gamePrinter.notify(new IncorrectInputEvent(languageFile));
            gamePrinter.notify(new BoardDimensionsEvent(languageFile));
            boardDimensionsResult = inputValidator.checkBoardDimensions(inputReader.readInput());
        }

        return boardDimensionsResult.getParsedResult();
    }
}