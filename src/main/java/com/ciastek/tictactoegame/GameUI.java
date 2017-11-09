package com.ciastek.tictactoegame;

import java.util.Scanner;

public class GameUI {
    private static Game game;
    private static String userInput;
    private static Scanner input;


    public static void main(String[] args) {
        System.out.println("TicTacToeGame");
        System.out.println("Choose first player: O or X?");
        input = new Scanner(System.in);
        userInput = input.nextLine();
        validatePlayerSign(userInput); //TODO: game.setFirstPlayer(input)


        System.out.println("Choose board size (greater than 2): ");
        int boardSize = input.nextInt();
        Board board = new Board(boardSize, boardSize);
        game = new Game(board);
        game.setFirstPlayer(PlayerCharacter.O);


        userInput = input.nextLine();
        System.out.println("Game started");


        while (!game.isFinished()){
            System.out.println(board.toString());
            System.out.println("Provide x: ");
            int x = input.nextInt();
            System.out.println("Provide y: ");
            int y = input.nextInt();

            game.play(x, y);
        }
    }


    private static void validatePlayerSign(String userInput) {

        if (userInput != "" && userInput.length() == 1) {
            if (userInput == "X" || userInput == "O") {
                System.out.println("Provided input: " + userInput);
            } else {
                System.out.println("Provide Player which starts the game: O or X");
            }
        } else {
            System.out.println("Provide Player which starts the game: O or X");
        }
    }

    private static void validateBoardSize(String userInput) {
    }
}
