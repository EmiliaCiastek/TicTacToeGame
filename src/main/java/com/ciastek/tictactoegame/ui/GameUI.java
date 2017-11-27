package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.board.BoardDimensionsResult;
import com.ciastek.tictactoegame.engine.game.Game;
import com.ciastek.tictactoegame.engine.game.GameBuilder;
import com.ciastek.tictactoegame.engine.player.FirstCharacterResult;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.victory.WinningConditionResult;

public class GameUI {
    private static InputReader inputReader;

    public static void main(String[] args) {
        //TODO: add quit option
        Printer gamePrinter = new Printer();

        inputReader = new InputReader();

        GameBuilder gameBuilder = new GameBuilder();

        gamePrinter.printWelcomeMessage();
        gameBuilder.withPlayers(setPlayer(PlayerCharacter.O), setPlayer(PlayerCharacter.X))
                .withBoardDimensions(setBoardDimensions())
                .withWinningCondition(setWinningCondition(gameBuilder.getBoardDimensions()))
                .withFirstPlayer(setFirstPlayer())
                .withObserver(gamePrinter)
                .withImputReader(inputReader);

        Game game = gameBuilder.build();
        System.out.println("Game started");

        while (!game.isFinished()) {
            game.play();
        }
    }

    private static Player setPlayer(PlayerCharacter playerCharacter) {
        InputValidator inputValidator = new InputValidator();
        System.out.println(String.format("Provide name for %s player", playerCharacter));
        PlayerResult oPlayerResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);

        while (!oPlayerResult.isValid()) {
            System.out.println("Provided name is incorrect. Name can contains only letters.");
            oPlayerResult = inputValidator.checkPlayerName(inputReader.readInput(), playerCharacter);
        }

        return oPlayerResult.getParsedResult();
    }

    private static PlayerCharacter setFirstPlayer() {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Choose first player: O or X?");
        FirstCharacterResult firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());

        while (!firstPlayerResult.isValid()) {
            System.out.println("Provided input is incorrect. Choose first player: O or X?");
            firstPlayerResult = inputValidator.checkPlayer(inputReader.readInput());
        }
        return firstPlayerResult.getParsedResult();
    }

    private static WinningCondition setWinningCondition(BoardDimensions dimensions) {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Provide winning condition: greater than 2 and smaller or equal " + Math.min(dimensions.getWidth(), dimensions.getHeight()));
        WinningConditionResult winningConditionResult = inputValidator.checkWinningCondition(inputReader.readInput(), dimensions);

        while (!winningConditionResult.isValid()) {
            System.out.println("Provided input is incorrect. Provide winning condition: greater than 2 and smaller or equal " + Math.min(dimensions.getWidth(), dimensions.getHeight()));
            winningConditionResult = inputValidator.checkWinningCondition(inputReader.readInput(), dimensions);
        }

        return winningConditionResult.getParsedValue();
    }

    private static BoardDimensions setBoardDimensions() {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Provide board size in format: width x height (without spaces). Minimum size 3x3, maximum size 100x100");

        BoardDimensionsResult boardDimensionsResult = inputValidator.checkBoardDimensions(inputReader.readInput());
        while (!boardDimensionsResult.isValid()) {
            System.out.println("Provided input is incorrect. \nProvide board size in format: width x height (without spaces). Minimum size 3x3, maximum size 100x100");
            boardDimensionsResult = inputValidator.checkBoardDimensions(inputReader.readInput());
        }

        return boardDimensionsResult.getParsedResult();
    }
}