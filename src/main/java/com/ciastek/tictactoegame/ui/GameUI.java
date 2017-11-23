package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.board.BoardDimensionsResult;
import com.ciastek.tictactoegame.engine.game.Game;
import com.ciastek.tictactoegame.engine.game.GameBuilder;
import com.ciastek.tictactoegame.engine.movement.Position;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.player.PlayerResult;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.victory.WinningConditionResult;

import java.util.Scanner;

public class GameUI {


    public static void main(String[] args) {
        //TODO: add quit option

        GameBuilder gameBuilder = new GameBuilder();

        System.out.println("TicTacToeGame");
        gameBuilder.withBoardDimensions(setBoardDimensions())
                .withWinningCondition(setWinningCondition(gameBuilder.getBoardDimensions()))
                .withFirstPlayer(setFirstPlayer());

        Game game = gameBuilder.build();
        System.out.println("Game started");

        while (!game.isFinished()) {
            try {
                game.play();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            // TODO (3): check if there is winner - after minimal number of moves
        }
    }

    private static PlayerCharacter setFirstPlayer() {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Choose first player: O or X?");
        Scanner inputPlayer = new Scanner(System.in);
        PlayerResult firstPlayerResult = inputValidator.checkPlayer(inputPlayer.nextLine());

        while (!firstPlayerResult.isValid()) {
            System.out.println("Provided input is incorrect. Choose first player: O or X?");
            firstPlayerResult = inputValidator.checkPlayer(inputPlayer.nextLine());
        }
        return firstPlayerResult.getParsedResult();
    }

    private static WinningCondition setWinningCondition(BoardDimensions dimensions) {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Provide winning condition: greater than 2 and smaller or equal board's width or height");
        Scanner inputCondition = new Scanner(System.in);
        WinningConditionResult winningConditionResult = inputValidator.checkWinningCondition(inputCondition.nextLine(), dimensions);

        while (!winningConditionResult.isValid()) {
            System.out.println("Provided input is incorrect. \nProvide winning condition: greater than 2 and smaller or equal board's width or height");
            winningConditionResult = inputValidator.checkWinningCondition(inputCondition.nextLine(), dimensions);
        }

        return winningConditionResult.getParsedValue();
    }

    private static BoardDimensions setBoardDimensions() {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Provide board size in format: width x height (without spaces). Minimum size 3x3, maximum size 100x100");
        Scanner sizeInput = new Scanner(System.in);

        BoardDimensionsResult boardDimensionsResult = inputValidator.checkBoardDimensions(sizeInput.nextLine());
        while (!boardDimensionsResult.isValid()) {
            System.out.println("Provided input is incorrect. \nProvide board size in format: width x height (without spaces). Minimum size 3x3, maximum size 100x100");
            boardDimensionsResult = inputValidator.checkBoardDimensions(sizeInput.nextLine());
        }

        return boardDimensionsResult.getParsedResult();
    }

    private static Position setPosition() {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Provide index: ");
        Scanner indexInput = new Scanner(System.in);

        PositionResult positionResult = inputValidator.checkPosition(indexInput.nextLine());
        while (!positionResult.isValid()) {
            System.out.println("Provided index is incorrect. Index has to be a number");
            positionResult = inputValidator.checkPosition(indexInput.nextLine());
        }

        return positionResult.getParsedResult();
    }
}