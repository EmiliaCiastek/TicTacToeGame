package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

@Test
public class GameTest {
    Game game;
    BoardDimensions boardDimensions;

    @BeforeMethod
    public void setUp(){
        int boardSize = 3;
        boardDimensions = new BoardDimensions(boardSize, boardSize);

        Board board = new Board(boardDimensions);
        game = new Game(board);
        game.setFirstPlayer(PlayerCharacter.O);
    }

    public void givenFirstPlayerOWhenSetFirstPlayerThenCurrentPlayerO(){
        assertEquals(game.getCurrentPlayer(), PlayerCharacter.O);
    }

    public void givenOPlayerMoveWhenPlayThenCurrentPlayerX(){
        game.play(1);

        assertEquals(game.getCurrentPlayer(), PlayerCharacter.X);
    }

    public void whenPlayThenBoardFieldSet(){
        int index = 1;
        game.play(index);
        PlayerCharacter actual = game.getBoardField(index);
        assertEquals(actual, PlayerCharacter.O);
    }

    public void playTest(){
        Board expectedBoard = new Board(boardDimensions);
        expectedBoard.add(0, PlayerCharacter.O);
        expectedBoard.add(1, PlayerCharacter.X);
        expectedBoard.add(6, PlayerCharacter.O);
        expectedBoard.add(8, PlayerCharacter.X);

        game.play(0); //O
        game.play(1); //X
        game.play(6); //O
        game.play(8); //X

        assertEquals(game.getBoard().toString(), expectedBoard.toString());
    }

    public void whenGameInitializedThenIsFinishedFalse(){
        assertFalse(game.isFinished());
    }

    public void whenBoardFilledThenGameIsFinished(){
        game.play(0); //O
        game.play(1); //X
        game.play(2); //O
        game.play(3); //X
        game.play(4); //O
        game.play(5); //X
        game.play(6); //O
        game.play(7); //X
        game.play(8); //O

        assertTrue(game.isFinished());
    }

}
