package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

public class GameTest {

    @Test
    public void givenPlayerXWonThreeTimesThenVictoryMessageShouldBePrinted(){
        String eventMessage = "Round over! Player X won! Congratulations!";
        Round fakeRound = new FakeRound();
        BoardDimensions boardDimensions = new BoardDimensions(3, 3);
        WinningCondition winningCondition = new WinningCondition(3);

        GameSettings gameSettings = new GameSettings(boardDimensions, winningCondition, PlayerCharacter.O);
        Game game = new Game(gameSettings, roundFabric -> fakeRound);

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));

        game.play();

        assertEquals(bytes.toString(), eventMessage);
    }

}
