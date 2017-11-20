package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RefereeTest {
    private Referee referee = new Referee(new WinningCondition(3));


    @Test
    public void givenNoWinningBoardPieceThenNoWinner(){
        BoardDimensions boardDimensions = new BoardDimensions(10, 12);
        Board board = new Board(boardDimensions);

        board.add(0, PlayerCharacter.X);
        board.add(1, PlayerCharacter.O);
        board.add(2, PlayerCharacter.X);

        assertFalse(referee.isWon(board, 2));
    }

    @Test
    public void givenWinningInColumnThenTrue(){
        BoardDimensions boardDimensions = new BoardDimensions(3, 3);
        Board board = new Board(boardDimensions);

        board.add(0, PlayerCharacter.NONE);
        board.add(1, PlayerCharacter.X);
        board.add(2, PlayerCharacter.O);
        board.add(3, PlayerCharacter.NONE);
        board.add(4, PlayerCharacter.X);
        board.add(5, PlayerCharacter.NONE);
        board.add(6, PlayerCharacter.O);
        board.add(7, PlayerCharacter.X);
        board.add(8, PlayerCharacter.NONE);

        assertTrue(referee.isWon(board, 1));
    }

    @Test
    public void givenWinningDiagonalThenTrue(){
        BoardDimensions boardDimensions = new BoardDimensions(4, 3);
        Board board = new Board(boardDimensions);
        board.add(0, PlayerCharacter.O);
        board.add(5, PlayerCharacter.O);
        board.add(10, PlayerCharacter.O);

        assertTrue(referee.isWon(board, 0));
    }

}
