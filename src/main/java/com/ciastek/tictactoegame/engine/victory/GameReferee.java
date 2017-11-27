package com.ciastek.tictactoegame.engine.victory;

import com.ciastek.tictactoegame.engine.player.Player;

public class GameReferee {
    private final String GAME_RESULT_MESSAGE = "And the winner is.... %s! %s:%d, %s:%d";
    private final String GAME_DRAW_RESULT_MESSAGE = "Game ended with draw! %s:%d, %s:%d";

    private Player firstPlayer;
    private Player secondPlayer;

    public GameReferee(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public String generateGameResult() {
        Player winner;
        String result;

        if(firstPlayer.getScore() == secondPlayer.getScore()){
            result = String.format(GAME_DRAW_RESULT_MESSAGE, firstPlayer.getCharacter(), firstPlayer.getScore(), secondPlayer.getCharacter(), secondPlayer.getScore());
        } else {
            winner = firstPlayer.getScore() > secondPlayer.getScore() ? firstPlayer : secondPlayer;

            result = String.format(GAME_RESULT_MESSAGE, winner.getName(), firstPlayer.getCharacter(), firstPlayer.getScore(), secondPlayer.getCharacter(), secondPlayer.getScore());
        }

        return result;
    }
}
