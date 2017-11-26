package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.player.Player;

public class FakePositionInput implements PositionInput {
    @Override
    public Position getPosition(Player player) {
        return new Position(0);
    }
}
