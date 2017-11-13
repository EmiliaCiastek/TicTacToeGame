package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class VerticalVictoryValidatorTest {

    @Test
    public void givenNoVictoryThenFalse(){
        VerticalVictoryValidator verticalValidator = new VerticalVictoryValidator(5);
        String column = "X O   X";

        assertFalse(verticalValidator.isVictory(column));
    }

    @Test
    public void givenXVictoryThenTrue(){
        VerticalVictoryValidator verticalValidator = new VerticalVictoryValidator(3);
        String column = "X X X";

        assertTrue(verticalValidator.isVictory(column));
    }

    @Test
    public void givenOVictoryThenTrue(){
        VerticalVictoryValidator verticalValidator = new VerticalVictoryValidator(9);
        String column = "O O O O O O O O O";

        assertTrue(verticalValidator.isVictory(column));
    }
}
