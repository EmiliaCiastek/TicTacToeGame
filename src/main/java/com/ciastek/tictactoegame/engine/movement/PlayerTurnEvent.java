package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.events.GameEvent;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

import java.util.ResourceBundle;

public class PlayerTurnEvent implements GameEvent {
    private PlayerCharacter character;
    private final ResourceBundle resourceBundle;

    public PlayerTurnEvent(PlayerCharacter character, String filename) {
        this.character = character;
        resourceBundle = ResourceBundle.getBundle(filename);
    }

    @Override
    public String getMessage() {
        String message = resourceBundle.getString("playerTurnMessage");
        return String.format(message, character);
    }
}
