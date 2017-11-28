package com.ciastek.tictactoegame.ui;

import java.util.Scanner;

public class InputReader {
    private Scanner inputScanner;

    public InputReader() {
        inputScanner = new Scanner(System.in);
    }

    public String readInput() {
        String line = inputScanner.nextLine();

        if(line.equalsIgnoreCase("Q")){
            System.exit(0);
        }

        return line;
    }
}
