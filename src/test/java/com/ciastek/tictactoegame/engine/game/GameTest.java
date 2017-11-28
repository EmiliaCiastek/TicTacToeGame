package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.GameEvent;
import com.ciastek.tictactoegame.engine.events.RoundEndedWithDrawEvent;
import com.ciastek.tictactoegame.engine.movement.FakePositionInput;
import com.ciastek.tictactoegame.engine.movement.PositionInput;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.ui.ConsolePrinter;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class GameTest {
    private Game game;
    private ByteArrayOutputStream bytes;
    private ConsolePrinter mockedPrinter;
    private GameSettings gameSettings;
    private PositionInput fakeInput;
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("Strings");

    @BeforeMethod
    public void setUp(){
        fakeInput = new FakePositionInput();
        BoardDimensions boardDimensions = new BoardDimensions(3, 3);
        WinningCondition winningCondition = new WinningCondition(3);
        Player firstPlayer = new Player(PlayerCharacter.O, "first");
        Player secondPlayer = new Player(PlayerCharacter.X, "second");

        gameSettings = new GameSettings(boardDimensions, winningCondition, firstPlayer, secondPlayer);
        mockedPrinter = mock(ConsolePrinter.class);


        bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
    }

    @Test
    public void givenDrawRoundThenDrawMessageShouldBePrinted(){
        ArgumentCaptor<RoundEndedWithDrawEvent> argumentCaptor = ArgumentCaptor.forClass(RoundEndedWithDrawEvent.class);
        game = new Game(gameSettings, roundFabric -> new FakeRoundWithDraw(), fakeInput, resourceBundle);
        game.registerObserver(mockedPrinter);
        game.play();

        verify(mockedPrinter, atLeast(3)).notify(argumentCaptor.capture());
        List<RoundEndedWithDrawEvent> values = filterEvents(argumentCaptor.getAllValues());

        assertEquals(values.size(), 3);
        assertEquals(values.get(0).getMessage(), "Round over with draw!");
    }

    private List<RoundEndedWithDrawEvent> filterEvents(List<RoundEndedWithDrawEvent> allEvents){
        List<RoundEndedWithDrawEvent> drawEvents = new ArrayList<>();

        for (GameEvent event : allEvents) {
            if (event instanceof RoundEndedWithDrawEvent){
                drawEvents.add((RoundEndedWithDrawEvent) event);
            }
        }

        return drawEvents;
    }
}
