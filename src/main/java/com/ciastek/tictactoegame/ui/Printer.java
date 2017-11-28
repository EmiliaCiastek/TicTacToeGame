package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.events.GameEvent;

public interface Printer extends Observer {
    default void initPrinter(){}

    @Override
    default void notify(GameEvent gameEvent) {
        printMessage(gameEvent.getMessage());
    }

    void printMessage(String message);

}
