package com.ciastek.tictactoegame.ui;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FilePrinter implements Printer {

    @Override
    public void initPrinter(){
        PrintStream fileStream = null;
        try {
            fileStream = new PrintStream("output.txt");
        } catch (FileNotFoundException e) {
        }
        System.setOut(fileStream);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
