package com.ciastek.tictactoegame.ui;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FilePrinter implements Printer {

    @Override
    public void initPrinter() {
        PrintStream fileStream;
        try {
            fileStream = new PrintStream("output.txt");
            System.setOut(fileStream);
        } catch (FileNotFoundException e) {
            System.out.println("File not found - default output is console");
        }
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}