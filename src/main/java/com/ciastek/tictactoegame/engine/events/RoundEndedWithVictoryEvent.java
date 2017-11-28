package com.ciastek.tictactoegame.engine.events;

import com.ciastek.tictactoegame.engine.player.Player;

import java.util.ResourceBundle;

public class RoundEndedWithVictoryEvent implements GameEvent {
    private final Player winner;
    private final ResourceBundle resourceBundle;

    public RoundEndedWithVictoryEvent(Player winner, String filename){
        resourceBundle = ResourceBundle.getBundle(filename);
        this.winner = winner;
    }

    @Override
    public String getMessage() {
        return String.format(resourceBundle.getString("roundEndedWithWinnerMessage"), winner.getCharacter(), winner.getName());
    }
}
