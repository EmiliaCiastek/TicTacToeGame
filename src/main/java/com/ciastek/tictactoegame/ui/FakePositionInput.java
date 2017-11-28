package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.movement.Position;
import com.ciastek.tictactoegame.engine.player.Player;

public class FakePositionInput implements PositionInput {
    @Override
    public PositionResult getPosition(Player player) {
        return new PositionResult(ResultState.VALID, new Position(0));
    }
}