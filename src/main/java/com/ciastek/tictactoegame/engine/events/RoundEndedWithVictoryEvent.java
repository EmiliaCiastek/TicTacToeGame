package com.ciastek.tictactoegame.engine.events;

import com.ciastek.tictactoegame.engine.player.Player;

public class RoundEndedWithVictoryEvent implements GameEvent {
    private final String ROUND_WINNER_MESSAGE = "Round over! Player %s won! Congratulations %s!"; //TODO: add winners name
    private final Player winner;

    public RoundEndedWithVictoryEvent(Player winner){
        this.winner = winner;
    }

    @Override
    public String getMessage() {
        return String.format(ROUND_WINNER_MESSAGE, winner.getCharacter(), winner.getName());
    }

    public Player getWinner() {
        return winner;
    }
}
