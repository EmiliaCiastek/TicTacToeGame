package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

public class Movement {

    private final Position position;
    private final PlayerCharacter character;

    public Movement(Position position, PlayerCharacter playerCharacter){
        this.position = position;
        this.character = playerCharacter;
    }

    public Position getPosition() {
        return position;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }
}
