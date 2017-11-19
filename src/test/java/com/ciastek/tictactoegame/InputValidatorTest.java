package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

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

}
