package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HorizontalVictoryValidatorTest {


    @Test
    public void givenNoVictoryThenFalse(){
        HorizontalVictoryValidator victory = new HorizontalVictoryValidator(3);

        String row = "X O X";

        assertFalse(victory.isVictory(row));
    }

    @Test
    public void givenXVictoryThenTrue(){
        HorizontalVictoryValidator victory = new HorizontalVictoryValidator(4);

        String row = "X X X X";

        assertTrue(victory.isVictory(row));
    }

    @Test
    public void givenOVictoryThenTrue(){
        HorizontalVictoryValidator victory = new HorizontalVictoryValidator(10);

        String row = "O O O O O O O O O O";
        assertTrue(victory.isVictory(row));
    }
}
