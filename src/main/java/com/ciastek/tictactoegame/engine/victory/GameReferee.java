package com.ciastek.tictactoegame.engine.victory;

import com.ciastek.tictactoegame.engine.player.Player;

import java.util.ResourceBundle;

public class GameReferee {
    private String GAME_RESULT_MESSAGE;
    private String GAME_DRAW_RESULT_MESSAGE;

    private Player firstPlayer;
    private Player secondPlayer;
    private ResourceBundle resourceBundle;

    public GameReferee(Player firstPlayer, Player secondPlayer, ResourceBundle resourceBundle) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.resourceBundle = resourceBundle;
    }

    public String generateGameResult() {
        Player winner;
        String result;

        if(firstPlayer.getScore() == secondPlayer.getScore()){
            GAME_DRAW_RESULT_MESSAGE = resourceBundle.getString("gameDrawResultMessage");
            result = String.format(GAME_DRAW_RESULT_MESSAGE, firstPlayer.getCharacter(), firstPlayer.getScore(), secondPlayer.getCharacter(), secondPlayer.getScore());
        } else {
            winner = firstPlayer.getScore() > secondPlayer.getScore() ? firstPlayer : secondPlayer;
            GAME_RESULT_MESSAGE = resourceBundle.getString("gameResultMessage");
            result = String.format(GAME_RESULT_MESSAGE, winner.getName(), firstPlayer.getCharacter(), firstPlayer.getScore(), secondPlayer.getCharacter(), secondPlayer.getScore());
        }

        return result;
    }
}
