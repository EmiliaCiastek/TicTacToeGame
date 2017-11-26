package com.ciastek.tictactoegame.engine.victory;

import com.ciastek.tictactoegame.engine.player.Player;
import java.util.Optional;

public class RoundResult {
    private boolean isWon = false;
    private Optional<Player> winner;

    public RoundResult(boolean isWon, Player winner) {
        this.isWon = isWon;
        this.winner = Optional.of(winner);
    }

    public RoundResult() {
        this.winner = Optional.empty();
    }

    public boolean isWon() {
        return isWon;
    }

    public Optional<Player> getWinner() {
        return winner;
    }
}