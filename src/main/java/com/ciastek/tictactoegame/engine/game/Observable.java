package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.events.GameEvent;

public interface Observable {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(GameEvent event);
}
