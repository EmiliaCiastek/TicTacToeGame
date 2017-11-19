package com.ciastek.tictactoegame;

import java.util.Scanner;

public class GameUI {
    private static Game game;
    private static String userInput;
    private static Scanner input;
    private static Player player;


    public static void main(String[] args) {

        // TODO (1): input validation
        // TODO (2): get win conditions from user
        // TODO (3): match number of matches always 3

        System.out.println("TicTacToeGame");
        System.out.println("I optimistically assume that you'll provide correct values :)");
        System.out.println("Choose first player: O or X?");
        input = new Scanner(System.in);
        userInput = input.nextLine();
        validatePlayerSign(userInput);

        System.out.println("Provide board width (greater than 2): ");
        int width = input.nextInt();
        System.out.println("Provide board height (greater than 2): ");
        int height = input.nextInt();
        BoardDimensions boardDimensions = new BoardDimensions(width, height);
        Board board = new Board(boardDimensions);
        game = new Game(board);
        game.setFirstPlayer(PlayerCharacter.valueOf(String.valueOf(userInput.charAt(0))));

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

    private static void validatePlayerSign(String userInput) {
        if (userInput != "" && userInput.length() == 1) {
            if (userInput == "X" || userInput == "O") {
                System.out.println("Provided input: " + userInput);
            }
        }
    }
}
