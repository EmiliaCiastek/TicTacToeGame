package com.ciastek.tictactoegame.ui;

public class ErrorPrinter implements Printer{

    @Override
    public void printMessage(String eventMessage){
        System.err.println(eventMessage);
    }
}
