package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.movement.Position;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.ui.PositionInput;

public class FakePositionInput implements PositionInput {
    @Override
    public Position getPosition(Player player) {
        return new Position(0);
    }
}
