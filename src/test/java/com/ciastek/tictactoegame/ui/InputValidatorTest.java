package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.board.BoardDimensionsResult;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.player.PlayerResult;
import com.ciastek.tictactoegame.engine.victory.WinningConditionResult;
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

        assertEquals(actual.getParsedResult(), PlayerCharacter.O);
        assertTrue(actual.isValid());
    }

    @Test
    public void givenIncorrectPlayerInputWhenValidateThenReturnEmptyPlayerResult(){
        input = "fwhfuyewrf";
        PlayerResult actual = validator.checkPlayer(input);

        assertEquals(actual.getParsedResult(), PlayerCharacter.NONE);
        assertFalse(actual.isValid());
    }

    @Test
    public void givenCorrectXPlayerInputWhenValidateThenReturnCorrectPlayerResult(){
        input = "X";
        PlayerResult actual = validator.checkPlayer(input);

        assertEquals(actual.getParsedResult(), PlayerCharacter.X);
        assertTrue(actual.isValid());
    }

    @Test
    public void givenEmptyInputWhenValidatePlayerThenReturnEmptyPlayerResult(){
        input = "";
        PlayerResult actual = validator.checkPlayer(input);

        assertEquals(actual.getParsedResult(), PlayerCharacter.NONE);
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
    public void givenWinningConditionGreaterThanBoardHeightWhenValidateThenReturnEmptyConditionResult(){
        dimensions = new BoardDimensions(3, 6);

        input = "7";

        WinningConditionResult result = validator.checkWinningCondition(input, dimensions);

        assertFalse(result.isValid());
    }

    @Test
    public void givenWinningConditionSmallerThanBoardWidthWhenValidateThenReturnCorrectConditionResult(){
        dimensions = new BoardDimensions(3, 6);
        input = "5";

        WinningConditionResult result = validator.checkWinningCondition(input, dimensions);

        assertTrue(result.isValid());
    }

    @Test
    public void givenCorrectBoardDimensionsWhenValidateThenReturnCorrectBoardDimensionsResult(){
        input = "5x6";

        BoardDimensionsResult result = validator.checkBoardDimensions(input);

        assertTrue(result.isValid());
        assertEquals(result.getParsedResult().getWidth(), 5);
        assertEquals(result.getParsedResult().getHeight(), 6);
    }

    @DataProvider(name = "incorrect board dimensions input")
    public static Object[] incorrectBoardDimensionsInput() {
        return new Object[]{"", " ", "bla", "/n", "2 x 4", " 3xfff"} ;
    }

    @Test (dataProvider = "incorrect board dimensions input")
    public void givenIncorrectFormatInputWhenValidateThenReturnEmptyBoardDimensionsResult(String incorrectInput){
        BoardDimensionsResult result = validator.checkBoardDimensions(incorrectInput);

        assertFalse(result.isValid());
    }

    @Test
    public void givenWidthGreaterThanMaxDimensionWhenValidateThenReturnEmptyBoardDimensionsResult(){
        input = "4x101";

        BoardDimensionsResult result = validator.checkBoardDimensions(input);

        assertFalse(result.isValid());
    }

    @Test
    public void givenHeightSmallerThanMinDimensionWhenValidateThenReturnEmptyBoardDimensionsResult(){
        input = "2x5";
        BoardDimensionsResult result = validator.checkBoardDimensions(input);

        assertFalse(result.isValid());
    }

    @DataProvider(name = "incorrect position input")
    public static Object[] incorrectPositionInput() {
        return new Object[]{"", " ", "bla", "/n", "2 x 4", " 3xfff"} ;
    }

    @Test (dataProvider = "incorrect position input")
    public void givenIncorrectPositionInputWhenValidateThenReturnEmptyPositionResult(String incorrectInput){
        PositionResult result = validator.checkPosition(incorrectInput);

        assertFalse(result.isValid());
    }
}
