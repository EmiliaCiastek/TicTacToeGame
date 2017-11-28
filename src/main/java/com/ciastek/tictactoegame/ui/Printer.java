package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.events.GameEvent;
import com.ciastek.tictactoegame.engine.game.Observer;

public class Printer implements Observer{

    @Override
    public void notify(GameEvent gameEvent) {
        printMessage(gameEvent.getMessage());
    }

    private void printMessage(String eventMessage){
        System.out.println(eventMessage);
    }
}