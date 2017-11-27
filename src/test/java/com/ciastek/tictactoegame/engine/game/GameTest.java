package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.GameEndedEvent;
import com.ciastek.tictactoegame.engine.events.GameEvent;
import com.ciastek.tictactoegame.engine.events.RoundEndedWithDrawEvent;
import com.ciastek.tictactoegame.engine.movement.FakePositionInput;
import com.ciastek.tictactoegame.engine.movement.PositionInput;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.ui.GameUI;
import com.ciastek.tictactoegame.ui.Printer;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class GameTest {
    private Game game;
    private ByteArrayOutputStream bytes;
    private Printer mockedPrinter;
    private GameSettings gameSettings;
    private PositionInput fakeInput;

    @BeforeMethod
    public void setUp(){
        fakeInput = new FakePositionInput();
        BoardDimensions boardDimensions = new BoardDimensions(3, 3);
        WinningCondition winningCondition = new WinningCondition(3);
        Player firstPlayer = new Player(PlayerCharacter.O, "first");
        Player secondPlayer = new Player(PlayerCharacter.X, "second");

        gameSettings = new GameSettings(boardDimensions, winningCondition, firstPlayer, secondPlayer);
        mockedPrinter = mock(Printer.class);


        bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
    }

    @Test
    public void givenPlayerXWonThreeTimesThenVictoryMessageShouldBePrinted(){
        Round fakeRound = new FakeRoundXWinner();

        ArgumentCaptor<GameEndedEvent> argumentCaptor = ArgumentCaptor.forClass(GameEndedEvent.class);
        game = new Game(gameSettings, roundFabric -> fakeRound, fakeInput);
        game.registerObserver(mockedPrinter);

        game.play();

        verify(mockedPrinter, atLeastOnce()).notify(argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue().getMessage(), "Game over!");
    }

    @Test
    public void givenDrawRoundThenDrawMessageShouldBePrinted(){
        ArgumentCaptor<RoundEndedWithDrawEvent> argumentCaptor = ArgumentCaptor.forClass(RoundEndedWithDrawEvent.class);
        game = new Game(gameSettings, roundFabric -> new FakeRoundWithDraw(), fakeInput);
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

    @DataProvider(name = "game sequences")
    public static Object[][] gameSequences(){
        return new Object[][]{
                {"PlayerO\nPlayerX\n3x3\n3\nO\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6", "And the winner is.... " + "PlayerO! O:9, X:0"},
                {"PlayerO\nPlayerX\n3x3\n3\nX\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6", "And the winner is.... " + "PlayerX! X:9, O:0"} //TODO: add Draw
        };
    }

    @Test(dataProvider = "game sequences")
    public void givenInputSequenceThenShouldDisplayGameOverMessage(String gameSequence, String expectedGameResult){
        System.setIn(new ByteArrayInputStream(gameSequence.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        GameUI.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        List<String> gameOutput = Arrays.asList(byteArrayOutputStream.toString().split("\n"));

        String actualLastLine = gameOutput.get(gameOutput.size() -1);

        assertEquals(actualLastLine, expectedGameResult);
    }
}
