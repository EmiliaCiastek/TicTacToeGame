package com.ciastek.tictactoegame;

import java.util.Scanner;

public class GameUI {
    private static Game game;
    private static String userInput;
    private static Scanner input;
    private static Player player;


    public static void main(String[] args) {

        // TODO:
        // 1) input validation
        // 3) get win conditions from user
        // 4) match and get number of matches in single game (from user)

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

       // userInput = input.nextLine();
        System.out.println("Game started");

        System.out.println(board.toString());
        MovementValidator validator = new MovementValidator(board);

        player = new Player(PlayerCharacter.O, game, validator);

        while (!game.isFinished()){
            System.out.println("Player: " + game.getCurrentPlayer() + " turn");
            System.out.println("Provide index: ");
            int index = input.nextInt();

            try {
                player.move(index);
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
