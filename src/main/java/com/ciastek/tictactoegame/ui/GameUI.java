package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.*;
import com.ciastek.tictactoegame.engine.game.Game;
import com.ciastek.tictactoegame.engine.game.GameBuilder;
import com.ciastek.tictactoegame.engine.player.FirstCharacterResult;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.victory.WinningConditionResult;

import java.util.ResourceBundle;

public class GameUI {
    private InputReader inputReader;
    private Printer gamePrinter;
    private ResourceBundle resourceBundle;
    private InputValidator inputValidator;

    public GameUI(Printer gamePrinter, InputReader inputReader) {
        this.gamePrinter = gamePrinter;
        this.inputReader = inputReader;
        inputValidator = new InputValidator();
    }

    public void run() {
        gamePrinter.notify(new WelcomeGameEvent());
        resourceBundle = ResourceBundle.getBundle(setLanguage());

        Game game = initGame();
        gamePrinter.notify(new GameStartedEvent(resourceBundle));

        while (!game.isFinished()) {
            game.play();
        }
    }

    private Game initGame() {
        GameBuilder gameBuilder = new GameBuilder();
        PositionScannerInput positionScannerInput = new PositionScannerInput(inputReader, resourceBundle, gamePrinter);

        gameBuilder.withPlayers(readPlayer(PlayerCharacter.O), readPlayer(PlayerCharacter.X))
                .withBoardDimensions(readBoardDimensions())
                .withWinningCondition(readWinningCondition(gameBuilder.getBoardDimensions()))
                .withFirstPlayer(readFirstPlayer())
                .withObserver(gamePrinter)
                .withPositionInput(positionScannerInput)
                .withLanguageFile(resourceBundle);

        return gameBuilder.build();
    }

    private String setLanguage() {
        String languageInput = inputReader.readInput();
        if (languageInput.equalsIgnoreCase("PL")) {
            return "Strings_pl";
        }

        return "Strings";
    }

    private Player readPlayer(PlayerCharacter playerCharacter) {
        gamePrinter.notify(new PlayerNameEvent(resourceBundle, playerCharacter));
        PlayerResult playerNameResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);

        while (playerNameResult.getResultState() == ResultState.INVALID) {
            gamePrinter.notify(new IncorrectInputEvent(resourceBundle));
            gamePrinter.notify(new PlayerNameEvent(resourceBundle, playerCharacter));
            playerNameResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);
        }

        return playerNameResult.getParsedResult();
    }

    private PlayerCharacter readFirstPlayer() {
        gamePrinter.notify(new FirstPlayerEvent(resourceBundle));
        FirstCharacterResult firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());

        while (firstPlayerResult.getResultState() == ResultState.INVALID) {
            gamePrinter.notify(new IncorrectInputEvent(resourceBundle));
            gamePrinter.notify(new FirstPlayerEvent(resourceBundle));
            firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());
        }
        return firstPlayerResult.getParsedResult();
    }

    private WinningCondition readWinningCondition(BoardDimensions dimensions) {
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

    private BoardDimensions readBoardDimensions() {
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