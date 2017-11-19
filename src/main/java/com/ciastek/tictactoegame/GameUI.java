package com.ciastek.tictactoegame;

import java.util.Scanner;

public class GameUI {
    private static Game game;
    private static Scanner input;
    private static Player player;


    public static void main(String[] args) {

        // TODO (1): input validation
        // TODO (2): get win conditions from user
        // TODO (3): match number of matches always 3

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

        setFirstPlayer(game);

        System.out.println("Game started");

        System.out.println(board.toString());

        player = new Player(PlayerCharacter.O);

        while (!game.isFinished()){
            System.out.println("Player: " + game.getCurrentPlayer() + " turn");
            System.out.println("Provide index: ");
            int index = input.nextInt();

            try {
                game.play(index);
            } catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }

            // TODO: check if there is winner - after minimal number of moves

            System.out.println(board.toString());
        }
    }

    private static void setFirstPlayer(Game game) {
        InputValidator inputValidator = new InputValidator();
        System.out.println("Choose first player: O or X?");
        PlayerResult firstPlayerResult = inputValidator.checkPlayer(input.nextLine());

        while(firstPlayerResult.isValid() != true){
            System.out.println("Provided input is incorrect. Choose first player: O or X?");
            firstPlayerResult = inputValidator.checkPlayer(input.nextLine());
        }
        game.setFirstPlayer(firstPlayerResult.getParsedPlayer());
    }
}
