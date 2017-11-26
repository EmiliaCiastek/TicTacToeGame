package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.events.GameEvent;

public interface Observer {
    void notify(GameEvent gameEvent);
}
