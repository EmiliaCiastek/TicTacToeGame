package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class GameTest {
    Game game;

    @BeforeMethod
    public void setUp(){
        int boardSize = 3;
        Board board = new Board(boardSize);
        game = new Game(board);
        game.setFirstPlayer(PlayerCharacter.O);
    }

    @Test
    public void givenFirstPlayerOWhenSetFirstPlayerThenCurrentPlayerO(){
        assertEquals(game.getCurrentPlayer(), PlayerCharacter.O);
    }

    @Test
    public void givenOPlayerMoveWhenPlayThenCurrentPlayerX(){
        game.play(1, 1);

        assertEquals(game.getCurrentPlayer(), PlayerCharacter.X);
    }

    @Test
    public void whenPlayThenBoardFieldSet(){
        int x = 1;
        int y = 2;
        game.play(x, y);
        PlayerCharacter actual = game.getBoard()[x-1][y-1];
        assertEquals(actual, PlayerCharacter.O);
    }

    @Test
    public void playTest(){
        PlayerCharacter[][] expectedBoard = {{PlayerCharacter.O, PlayerCharacter.NONE, PlayerCharacter.O},
                                             {PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE},
                                             {PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.X}};
        game.play(1,1); //O
        game.play(2,1); //X
        game.play(1,3); //O
        game.play(3,3); //X

        for (int i = 0; i < game.getBoard().length; i++) {
            assertEquals(game.getBoard()[i], expectedBoard[i]);
        }
    }

    @Test
    public void whenGameInitializedThenIsFinishedFalse(){
        assertFalse(game.isFinished());
    }

    @Test
    public void whenBoardFilledThenGameIsFinished(){
        game.play(1,1); //O
        game.play(2,1); //X
        game.play(1,3); //O
        game.play(3,3); //X
        game.play(2,2); //O
        game.play(1,2); //X
        game.play(2,3); //O
        game.play(3,1); //X
        game.play(3,2); //O

        assertTrue(game.isFinished());
    }
}
