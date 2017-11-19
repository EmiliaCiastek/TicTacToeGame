package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlayerResultTest {

    @Test
    public void givenCorrectInputThenInputParsed(){
        String input = "X";
        PlayerResult result = new PlayerResult(true, input);

        assertEquals(result.getParsedPlayer(), PlayerCharacter.X);
    }

    @Test
    public void givenIncorrectInputThenInputParsedToEmpty(){
        String input = "dfhwuirf";
        PlayerResult result = new PlayerResult(false, input);

        assertEquals(result.getParsedPlayer(), PlayerCharacter.NONE);
    }

    @Test
    public void givenCorrectInputThenIsValidTrue(){
        String input = "X";
        PlayerResult result = new PlayerResult(true, input);

        assertTrue(result.isValid());
    }

    @Test
    public void givenIncorrectInputThenIsValidFalse(){
        String input = "dfhwuirf";
        PlayerResult result = new PlayerResult(false, input);

        assertFalse(result.isValid());
    }
}