package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RefereeTest {

    @Test
    public void givenNoWinningBoardPieceThenNoWinner(){
        Referee referee = new Referee(3);
        BoardDimensions boardDimensions = new BoardDimensions(10, 12);
        Board board = new Board(boardDimensions);

        board.add(0, PlayerCharacter.X);
        board.add(1, PlayerCharacter.O);
        board.add(2, PlayerCharacter.X);


        assertFalse(referee.isWon(board, 2));
    }
/*
    @Test
    public void givenWinningInColumnThenTrue(){
        Referee referee = new Referee(3);

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

        System.out.println(board.toString());
        assertTrue(referee.isWon(board, 2));
    }
*/
}
