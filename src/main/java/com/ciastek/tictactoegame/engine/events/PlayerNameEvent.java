package com.ciastek.tictactoegame.engine.events;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

import java.util.ResourceBundle;

public class PlayerNameEvent implements GameEvent{
    private PlayerCharacter playerCharacter;
    private ResourceBundle resourceBundle;

    public PlayerNameEvent(ResourceBundle resourceBundle, PlayerCharacter playerCharacter){
        this.resourceBundle = resourceBundle;
        this.playerCharacter = playerCharacter;
    }

    @Override
    public String getMessage() {
        return String.format(resourceBundle.getString("providePlayerNameMessage"), playerCharacter);
    }
}