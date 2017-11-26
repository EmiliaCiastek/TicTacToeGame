package com.ciastek.tictactoegame.engine.victory;

import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

public class RoundResult {
    private boolean isWon = false;
    private Player winner;

    public RoundResult(boolean isWon, Player winner) {
        this.isWon = isWon;
        this.winner = winner;
    }

    public RoundResult(){
        this.winner = new Player(PlayerCharacter.NONE);
    }

    public boolean isWon(){
        return isWon;
    }

    public Player getWinner() {
        return winner;
    }
}
