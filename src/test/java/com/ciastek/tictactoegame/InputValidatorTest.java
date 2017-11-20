package com.ciastek.tictactoegame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class InputValidatorTest {
    private InputValidator validator = new InputValidator();
    private String input;
    private BoardDimensions dimensions = new BoardDimensions(5, 6);

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

    @Test
    public void givenSmallerThen3WinningConditionValueWhenValidateThenReturnEmptyConditionResult(){
        input = "2";

        WinningConditionResult result = validator.checkWinningCondition(input, dimensions);

        assertFalse(result.isValid());
    }

    @Test
    public void givenCorrectValueOfWinningConditionWhenValidateThenReturnWinningConditionResult(){
        input = "5";

        WinningConditionResult result = validator.checkWinningCondition(input, dimensions);

        assertEquals(result.getParsedValue().asInt(), 5);
        assertTrue(result.isValid());
    }


    @DataProvider(name = "incorrect input")
    public static Object[] incorrectInputWinningCondition() {
        return new Object[]{"", " ", "bla", "/n"} ;
    }


    @Test (dataProvider = "incorrect input")
    public void givenIncorrectStringOfWinningConditionWhenValidateThenReturnEmptyConditionResult(String incorrectInput){
        WinningConditionResult result = validator.checkWinningCondition(incorrectInput, dimensions);

        assertFalse(result.isValid());
    }

    @Test
    public void givenWinningConditionGreaterThenBoardDimensionsWhenValidateThenReturnEmptyConditionResult(){
        input = "7";

        WinningConditionResult result = validator.checkWinningCondition(input, dimensions);

        assertFalse(result.isValid());
    }

}
