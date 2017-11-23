package com.ciastek.tictactoegame.engine.events;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

public class RoundEndedWithVictoryEvent implements GameEvent {
    private final String ROUND_WINNER_MESSAGE = "Round over! Player %s won! Congratulations!"; //TODO: add winners name
    private PlayerCharacter winnerChar;

    public RoundEndedWithVictoryEvent(PlayerCharacter winner){
        this.winnerChar = winner;
    }

    @Override
    public String getMessage() {
        return String.format(ROUND_WINNER_MESSAGE, winnerChar);
    }
}
