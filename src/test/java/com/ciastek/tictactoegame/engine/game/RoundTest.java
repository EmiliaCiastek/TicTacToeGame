package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RoundTest {
    private GameSettings gameSettings;
    private Round round;

    @BeforeMethod
    public void setUp(){
        gameSettings = new GameSettings(new BoardDimensions(3, 3),
                new WinningCondition(3), PlayerCharacter.O);
        round = new Round(gameSettings);
    }

    @Test
    public void whenRoundInitializeThenNewEmptyBoardCreated(){
        Board board = round.getBoard();

        assertEquals(board.getBoardDimensions(), gameSettings.getBoardDimensions());
        assertEquals(board.getBoardDimensions(), gameSettings.getBoardDimensions());
    }

    @Test
    public void whenOPlayThenCurrentPlayerX(){
        int index = 0;
        round.play(index);

        assertEquals(round.getCurrentPlayer(), PlayerCharacter.X);
    }

    @Test
    public void whenPlayThenBoardFieldSet(){
        Board board = round.getBoard();
        int index = 1;
        round.play(index);
        PlayerCharacter actual = board.getCharacterAt(index);

        assertEquals(actual, PlayerCharacter.O);
    }

    @Test
    public void whenRoundInitializedThenIsFinishedFalse(){
        assertFalse(round.isFinished());
    }

    @Test
    public void whenBoardFilledThenRoundIsFinished(){
        round.play(0); //O
        round.play(1); //X
        round.play(2); //O
        round.play(3); //X
        round.play(4); //O
        round.play(5); //X
        round.play(6); //O
        round.play(7); //X
        round.play(8); //O

        assertTrue(round.isFinished());
    }

    @Test
    public void whenVictoryThenRoundFinished(){
        round.play(0); //O
        round.play(4); //X
        round.play(1); //O
        round.play(3); //X
        round.play(2); //O

        assertTrue(round.isFinished());
    }

    @DataProvider(name = "Incorrect moves")
    public static Object[] incorrectMoves(){
        return new Object[] { -1, 12, 0};
    }
    @Test(dataProvider = "Incorrect moves",
            expectedExceptions = IllegalArgumentException.class)
    public void givenIncorrectMovesThenThrowException(int incorrectIndex){
        round.play(0);
        round.play(incorrectIndex);
    }
}