package com.ciastek.tictactoegame.engine.events;

import com.ciastek.tictactoegame.engine.player.Player;
import java.util.ResourceBundle;

public class RoundEndedWithVictoryEvent implements GameEvent {
    private final Player winner;
    private final ResourceBundle resourceBundle;

    public RoundEndedWithVictoryEvent(ResourceBundle resourceBundle, Player winner){
        this.resourceBundle = resourceBundle;
        this.winner = winner;
    }

    @Override
    public String getMessage() {
        return String.format(resourceBundle.getString("roundEndedWithWinnerMessage"), winner.getCharacter(), winner.getName());
    }
}