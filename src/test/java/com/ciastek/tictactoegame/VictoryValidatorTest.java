package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class VictoryValidatorTest {


    @Test
    public void givenNoVictoryThenFalse(){
        VictoryValidator victory = new VictoryValidator(3);

        String row = "X O X";

        assertFalse(victory.isVictory(row));
    }

    @Test
    public void givenXVictoryThenTrue(){
        VictoryValidator victory = new VictoryValidator(4);

        String row = "X X X X";

        assertTrue(victory.isVictory(row));
    }

    @Test
    public void givenOVictoryThenTrue(){
        VictoryValidator victory = new VictoryValidator(10);

        String row = "O O O O O O O O O O";
        assertTrue(victory.isVictory(row));
    }

    @Test
    public void givenNoVictoryWithFourOThenFalse(){
        VictoryValidator victory = new VictoryValidator(3);
        String row = "O O X O X";
        assertFalse(victory.isVictory(row));
    }
}
