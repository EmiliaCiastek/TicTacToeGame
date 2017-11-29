package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.ui.*;

public class Application {
    public static void main(String[] args) {
        ArgumentsParser argsParser = new ArgumentsParser();
        Printer gamePrinter = argsParser.parse(args);
        gamePrinter.initPrinter();
        InputReader inputReader;
        inputReader = new InputReader();

        GameUI gameUI = new GameUI(gamePrinter, inputReader);
        gameUI.run();
    }
}