package com.ciastek.tictactoegame.ui;

public class ConsolePrinter implements Printer{

    @Override
    public void printMessage(String eventMessage){
        System.out.println(eventMessage);
    }
}