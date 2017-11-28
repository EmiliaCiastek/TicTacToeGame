package com.ciastek.tictactoegame.engine.events;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

import java.util.ResourceBundle;

public class PlayerTurnEvent implements GameEvent {
    private PlayerCharacter character;
    private final ResourceBundle resourceBundle;

    public PlayerTurnEvent(ResourceBundle resourceBundle, PlayerCharacter character) {
        this.character = character;
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage() {
        String message = resourceBundle.getString("playerTurnMessage");
        return String.format(message, character);
    }
}
