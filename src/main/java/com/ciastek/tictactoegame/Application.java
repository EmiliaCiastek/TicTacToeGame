package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.ui.*;

public class Application {
    public static void main(String[] args) {
        Printer gamePrinter = choosePrinter(args);
        gamePrinter.initPrinter();
        InputReader inputReader; //TODO: add setting input reader based on args
        inputReader = new InputReader();

        GameUI gameUI = new GameUI(gamePrinter, inputReader);
        gameUI.run();
    }

    private static Printer choosePrinter(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "err":
                    return new ErrorPrinter();
                case "file":
                    return new FilePrinter();
                default:
                    return new ConsolePrinter();
            }
        }
        return new ConsolePrinter();
    }
}