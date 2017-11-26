package acceptance;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.GameEndedEvent;
import com.ciastek.tictactoegame.engine.game.FakeRoundXWinner;
import com.ciastek.tictactoegame.engine.game.Game;
import com.ciastek.tictactoegame.engine.game.GameSettings;
import com.ciastek.tictactoegame.engine.game.Round;
import com.ciastek.tictactoegame.engine.movement.FakePositionInput;
import com.ciastek.tictactoegame.engine.movement.PositionInput;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.ui.GameUI;
import com.ciastek.tictactoegame.ui.Printer;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

public class Steps {
    private Game game;
    private ByteArrayOutputStream bytes;
    private Printer mockedPrinter;
    private GameSettings gameSettings;
    private PositionInput fakeInput;

    @Given("application started")
    public void givenApplicationStarted(){
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

    @Then("welcome printed")
    public void thenWelcomePrinted() {
        Round fakeRound = new FakeRoundXWinner();

        ArgumentCaptor<GameEndedEvent> argumentCaptor = ArgumentCaptor.forClass(GameEndedEvent.class);
        game = new Game(gameSettings, roundFabric -> fakeRound, fakeInput);
        game.registerObserver(mockedPrinter);

        game.play();

        verify(mockedPrinter, atLeastOnce()).notify(argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue().getMessage(), "Game over!");
    }
}
