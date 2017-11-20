package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.game.Game;
import com.ciastek.tictactoegame.engine.game.GameSettings;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.player.PlayerResult;

import java.util.Scanner;

public class GameUI {
    private static Game game;
    private static Scanner input;
    private static Player player;


    public static void main(String[] args) {

        // TODO (1): input validation
        // TODO (2): get win conditions from user
        // TODO (3): match number of matches always 3

        GameSettings settings = new GameSettings();
        System.out.println("TicTacToeGame");
        System.out.println("I optimistically assume that you'll provide correct values :)");
        input = new Scanner(System.in);

        System.out.println("Provide board width (greater than 2): ");
        int width = input.nextInt();
        System.out.println("Provide board height (greater than 2): ");
        int height = input.nextInt();
        BoardDimensions boardDimensions = new BoardDimensions(width, height);
        Board board = new Board(boardDimensions);
        game = new Game(board);
       setWinningCondition(settings, boardDimensions);

        setFirstPlayer(game);

        System.out.println("Game started");

        System.out.println(board.toString());

        player = new Player(PlayerCharacter.O);

        while (!game.isFinished()) {
            System.out.println("Player: " + game.getCurrentPlayer() + " turn");
            System.out.println("Provide index: ");
            int index = input.nextInt();

            try {
                game.play(index);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            // TODO: check if there is winner - after minimal number of moves

            System.out.println(board.toString());
        }
    }

    private static void setFirstPlayer(Game game) {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Choose first player: O or X?");
        Scanner inputPlayer = new Scanner(System.in);
        PlayerResult firstPlayerResult = inputValidator.checkPlayer(inputPlayer.nextLine());

        while (firstPlayerResult.isValid() != true) {
            System.out.println("Provided input is incorrect. Choose first player: O or X?");
            firstPlayerResult = inputValidator.checkPlayer(inputPlayer.nextLine());
        }
        game.setFirstPlayer(firstPlayerResult.getParsedPlayer());
    }

    private static void setWinningCondition(GameSettings settings, BoardDimensions dimensions) {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Provide winning condition: greater than 2 and smaller or equal board's width or height");
        Scanner inputCondition = new Scanner(System.in);
        WinningConditionResult winningConditionResult = inputValidator.checkWinningCondition(inputCondition.nextLine(), dimensions);

        while (winningConditionResult.isValid() != true) {
            System.out.println("Provided input is incorrect. \nProvide winning condition: greater than 2 and smaller or equal board's width or height");
            winningConditionResult = inputValidator.checkWinningCondition(inputCondition.nextLine(), dimensions);
        }

    }
}