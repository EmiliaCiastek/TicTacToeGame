package com.ciastek.tictactoegame.engine.victory;

import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

import static org.testng.Assert.assertEquals;

public class GameRefereeTest {

    @Test
    public void givenPlayersWithDrawScoresWhenCheckGameWinnerThenReturnStringMessage(){
        Player firstPlayer = new Player(PlayerCharacter.O, "PlayerO");
        Player secondPlayer = new Player(PlayerCharacter.X, "PlayerX");

        firstPlayer.addPoints(2);
        secondPlayer.addPoints(2);

        GameReferee gameReferee = new GameReferee(firstPlayer, secondPlayer, ResourceBundle.getBundle("Strings"));
        String expectedResult = "Game ended with draw! O:2, X:2";

        assertEquals(gameReferee.generateGameResult(), expectedResult);
    }

    @Test
    public void givenPlayersWithXWonWhenCheckGameWinnerThenReturnStringMessage(){
        Player firstPlayer = new Player(PlayerCharacter.O, "PlayerO");
        Player secondPlayer = new Player(PlayerCharacter.X, "PlayerX");

        firstPlayer.addPoints(2);
        secondPlayer.addPoints(3);

        GameReferee gameReferee = new GameReferee(firstPlayer, secondPlayer, ResourceBundle.getBundle("Strings"));
        String expectedResult = "And the winner is.... PlayerX! O:2, X:3";

        assertEquals(gameReferee.generateGameResult(), expectedResult);
    }
}