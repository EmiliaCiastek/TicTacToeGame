package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.GameEndedEvent;
import com.ciastek.tictactoegame.engine.movement.FakePositionInput;
import com.ciastek.tictactoegame.engine.movement.PositionInput;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.ui.Printer;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class GameTest {
    private Game game;
    private ByteArrayOutputStream bytes;
    private Printer mockedPrinter;

    @BeforeMethod
    public void setUp(){
        Round fakeRound = new FakeRound();
        PositionInput fakeInput = new FakePositionInput();
        BoardDimensions boardDimensions = new BoardDimensions(3, 3);
        WinningCondition winningCondition = new WinningCondition(3);

        GameSettings gameSettings = new GameSettings(boardDimensions, winningCondition, PlayerCharacter.O);
        mockedPrinter = mock(Printer.class);
        game = new Game(gameSettings, roundFabric -> fakeRound, fakeInput);
        game.registerObserver(mockedPrinter);

        bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
    }

    @Test
    public void givenPlayerXWonThreeTimesThenVictoryMessageShouldBePrinted(){
        ArgumentCaptor<GameEndedEvent> argumentCaptor = ArgumentCaptor.forClass(GameEndedEvent.class);

        game.play();

        verify(mockedPrinter, atLeastOnce()).notify(argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue().getMessage(), "Game over!");
    }
}
