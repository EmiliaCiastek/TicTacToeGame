package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RefereeTest {

    @Test
    public void givenNoWinningBoardPieceThenNoWinner(){
        Referee referee = new Referee(3);
        // TODO: add winningCondition and BoardPiece
        List<PlayerCharacter> boardPiece = new ArrayList<>(9);

        boardPiece.add(PlayerCharacter.O);
        boardPiece.add(PlayerCharacter.X);
        boardPiece.add(PlayerCharacter.O);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);

        assertFalse(referee.isWon(boardPiece));
    }

   /* @Test
    public void givenHorizontalWinningBoardPieceThenTrue(){
        Referee referee = new Referee(3);
        // TODO: add winningCondition and BoardPiece
        List<PlayerCharacter> boardPiece = new ArrayList<>(9);

        boardPiece.add(PlayerCharacter.O);
        boardPiece.add(PlayerCharacter.O);
        boardPiece.add(PlayerCharacter.O);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);

        assertTrue(referee.isWon(boardPiece));
    }

    */

}
