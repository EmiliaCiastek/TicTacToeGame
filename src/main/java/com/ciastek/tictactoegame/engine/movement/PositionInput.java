package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.player.Player;

public interface PositionInput {
   Position getPosition(Player player);
}