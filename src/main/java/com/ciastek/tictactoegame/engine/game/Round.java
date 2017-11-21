package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.movement.Movement;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

public class Round {
    private PlayerCharacter currentPlayer;
    private GameSettings gameSettings;

    public Round(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        currentPlayer = gameSettings.getFirstPlayer();
    }

    public void play(Movement movement) {

    }

    public PlayerCharacter getCurrentPlayer() {
        return currentPlayer;
    }
}
