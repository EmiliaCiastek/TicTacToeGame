package com.ciastek.tictactoegame.engine.events;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

public class PlayerNameEvent implements GameEvent{
    private final String PLAYER_NAME_EVENT = "Provide name for %s player. Name should contains only letters.";
    private PlayerCharacter playerCharacter;

    public PlayerNameEvent(PlayerCharacter playerCharacter){
        this.playerCharacter = playerCharacter;
    }

    @Override
    public String getMessage() {
        return String.format(PLAYER_NAME_EVENT, playerCharacter);
    }
}
