package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class InputValidatorTest {
    private InputValidator validator = new InputValidator();
    private String input;
    private boolean isValid;

    @Test
    public void givenEmptyStringWhenIsValidThenFalse(){
        input = "";
        isValid = validator.isValid(input);

        assertFalse(isValid);
    }

    @Test
    public void givenStringWithSingleSpaceWhenIsValidThenFalse(){
        input = " ";
        isValid = validator.isValid(input);

        assertFalse(isValid);
    }

    @Test
    public void givenNewLineInputWhenIsValidThenFalse(){
        input = "\n";
        isValid = validator.isValid(input);

        assertFalse(isValid);
    }

    @Test
    public void givenCorrectOPlayerInputWhenValidateThenReturnCorrectPlayerResult(){
        input = "O";
        PlayerResult actual = validator.checkPlayer(input);

        assertEquals(actual.getParsedPlayer(), PlayerCharacter.O);
        assertTrue(actual.isValid());
    }

    @Test
    public void givenIncorrectPlayerInputWhenValidateThenReturnEmptyPlayerResult(){
        input = "fwhfuyewrf";
        PlayerResult actual = validator.checkPlayer(input);

        assertEquals(actual.getParsedPlayer(), PlayerCharacter.NONE);
        assertFalse(actual.isValid());
    }

    @Test
    public void givenCorrectXPlayerInputWhenValidateThenReturnCorrectPlayerResult(){
        input = "X";
        PlayerResult actual = validator.checkPlayer(input);

        assertEquals(actual.getParsedPlayer(), PlayerCharacter.X);
        assertTrue(actual.isValid());
    }

    @Test
    public void givenEmptyInputWhenValidatePlayerThenReturnEmptyPlayerResult(){
        input = "";
        PlayerResult actual = validator.checkPlayer(input);

        assertEquals(actual.getParsedPlayer(), PlayerCharacter.NONE);
        assertFalse(actual.isValid());
    }
}
