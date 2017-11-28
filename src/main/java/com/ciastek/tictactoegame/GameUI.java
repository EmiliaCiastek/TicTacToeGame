package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.*;
import com.ciastek.tictactoegame.engine.game.Game;
import com.ciastek.tictactoegame.engine.game.GameBuilder;
import com.ciastek.tictactoegame.engine.player.FirstCharacterResult;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.victory.WinningConditionResult;
import com.ciastek.tictactoegame.ui.*;

import java.util.ResourceBundle;

public class GameUI {
    private static InputReader inputReader; //TODO: add setting input reader
    private static Printer gamePrinter;
    private static ResourceBundle resourceBundle;
    private static InputValidator inputValidator;


    public static void main(String[] args) {

        choosePrinter(args);

        //TODO: add quit option

        inputReader = new InputReader();
        inputValidator = new InputValidator();

        GameBuilder gameBuilder = new GameBuilder();

        gamePrinter.notify(new WelcomeGameEvent());

        resourceBundle = ResourceBundle.getBundle(setLanguage());

        PositionScannerInput positionScannerInput = new PositionScannerInput(inputReader, resourceBundle, gamePrinter);

        gameBuilder.withPlayers(setPlayer(PlayerCharacter.O), setPlayer(PlayerCharacter.X))
                .withBoardDimensions(setBoardDimensions())
                .withWinningCondition(setWinningCondition(gameBuilder.getBoardDimensions()))
                .withFirstPlayer(setFirstPlayer())
                .withObserver(gamePrinter)
                .withPositionInput(positionScannerInput)
                .withLanguageFile(resourceBundle);

        Game game = gameBuilder.build();

        gamePrinter.notify(new GameStartedEvent(resourceBundle));

        while (!game.isFinished()) {
            game.play();
        }
    }

    private static void choosePrinter(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "err":
                    gamePrinter = new ErrorPrinter();
                    break;
                case "file":
                    gamePrinter = new FilePrinter();
                    break;
                default:
                    gamePrinter = new ConsolePrinter();
                    break;
            }

        } else {
            gamePrinter = new ConsolePrinter();
        }

        gamePrinter.initPrinter();
    }

    private static String setLanguage() {
        String languageInput = inputReader.readInput();
        if (languageInput.equalsIgnoreCase("PL")) {
            return "Strings_pl";
        }

        return "Strings";
    }

    private static Player setPlayer(PlayerCharacter playerCharacter) {
        gamePrinter.notify(new PlayerNameEvent(resourceBundle, playerCharacter));
        PlayerResult playerNameResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);

        while (playerNameResult.getResultState() == ResultState.INVALID) {
            gamePrinter.notify(new IncorrectInputEvent(resourceBundle));
            gamePrinter.notify(new PlayerNameEvent(resourceBundle, playerCharacter));
            playerNameResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);
        }

        return playerNameResult.getParsedResult();
    }

    private static PlayerCharacter setFirstPlayer() {
        gamePrinter.notify(new FirstPlayerEvent(resourceBundle));
        FirstCharacterResult firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());

        while (firstPlayerResult.getResultState() == ResultState.INVALID) {
            gamePrinter.notify(new IncorrectInputEvent(resourceBundle));
            gamePrinter.notify(new FirstPlayerEvent(resourceBundle));
            firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());
        }
        return firstPlayerResult.getParsedResult();
    }

    private static WinningCondition setWinningCondition(BoardDimensions dimensions) {
        int maxWinningConditionValue = Math.min(dimensions.getWidth(), dimensions.getHeight());
        gamePrinter.notify(new WinningConditionEvent(resourceBundle, maxWinningConditionValue));
        WinningConditionResult winningConditionResult = inputValidator.checkWinningCondition(inputReader.readInput(), dimensions);

        while (winningConditionResult.getResultState() == ResultState.INVALID) {
            gamePrinter.notify(new IncorrectInputEvent(resourceBundle));
            gamePrinter.notify(new WinningConditionEvent(resourceBundle, maxWinningConditionValue));
            winningConditionResult = inputValidator.checkWinningCondition(inputReader.readInput(), dimensions);
        }

        return winningConditionResult.getParsedResult();
    }

    private static BoardDimensions setBoardDimensions() {
        gamePrinter.notify(new BoardDimensionsEvent(resourceBundle));

        BoardDimensionsResult boardDimensionsResult = inputValidator.checkBoardDimensions(inputReader.readInput());
        while (boardDimensionsResult.getResultState() == ResultState.INVALID) {
            gamePrinter.notify(new IncorrectInputEvent(resourceBundle));
            gamePrinter.notify(new BoardDimensionsEvent(resourceBundle));
            boardDimensionsResult = inputValidator.checkBoardDimensions(inputReader.readInput());
        }

        return boardDimensionsResult.getParsedResult();
    }
}