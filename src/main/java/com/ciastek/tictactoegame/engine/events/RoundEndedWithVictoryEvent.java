package com.ciastek.tictactoegame.engine.events;

import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

public class RoundEndedWithVictoryEvent implements GameEvent {
    private final String ROUND_WINNER_MESSAGE = "Round over! Player %s won! Congratulations %s!"; //TODO: add winners name
    private final String winnerName;
    private PlayerCharacter winnerChar;

    public RoundEndedWithVictoryEvent(Player winner){
        this.winnerChar = winner.getCharacter();
        this.winnerName = winner.getName();
    }

    @Override
    public String getMessage() {
        return String.format(ROUND_WINNER_MESSAGE, winnerChar, winnerName);
    }
}
