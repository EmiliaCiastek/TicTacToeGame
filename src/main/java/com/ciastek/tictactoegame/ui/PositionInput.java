package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.movement.Position;
import com.ciastek.tictactoegame.engine.player.Player;

public interface PositionInput {
   Position getPosition(Player player);
}