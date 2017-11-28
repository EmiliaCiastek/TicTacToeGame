package com.ciastek.tictactoegame.ui;

import java.util.Scanner;

public class InputReader {
    private Scanner inputScanner;

    public InputReader() {
        inputScanner = new Scanner(System.in);
    }

    public String readInput() {
        return inputScanner.nextLine();
    }
}