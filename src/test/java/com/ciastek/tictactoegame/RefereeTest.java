package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RefereeTest {

    private Referee referee;

    @BeforeMethod
    public void setUp() {
        referee = new Referee();
    }

    @Test
    public void givenNoWinnerStringWhenGetWinnerThenNone() {
        String boardPiece = "[ , O, X,  , X, O,  , O,  ]";
        System.out.println(boardPiece);

        assertEquals(referee.getWinner(boardPiece), PlayerCharacter.NONE);
    }

}
