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
        validatePlayerSign(userInput);
        //System.out.println(new Board(6));


        System.out.println("Choose board size (greater than 2): ");
        userInput = input.nextLine();
        System.out.println("Game started");

        /*
        while (!game.isFinished()){

        }
        */

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
