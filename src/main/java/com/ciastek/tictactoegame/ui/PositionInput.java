package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.player.Player;

public interface PositionInput {
    PositionResult getPosition(Player player);
}