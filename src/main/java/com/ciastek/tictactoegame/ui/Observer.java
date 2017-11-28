package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.events.GameEvent;

public interface Observer {
    void notify(GameEvent gameEvent);
}
