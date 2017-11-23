package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.events.GameEvent;

public class Printer {
    public void printMessage(GameEvent event){
        System.out.println(event.getMessage());
    }
}