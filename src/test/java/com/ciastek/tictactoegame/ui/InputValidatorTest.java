package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.player.FirstCharacterResult;
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

    @DataProvider(name = "first player")
    public static Object[][] firstPlayer(){
        return new Object[][] {
                {"O", PlayerCharacter.O},
                {"o", PlayerCharacter.O},
                {"X", PlayerCharacter.X},
                {"x", PlayerCharacter.X},
        };
    }
    @Test(dataProvider = "first player")
    public void givenCorrectFirstPlayerInputWhenValidateThenReturnFirstCharacterResult(String inputPlayer, PlayerCharacter expected){
        FirstCharacterResult actual = validator.checkPlayer(inputPlayer);

        assertEquals(actual.getParsedResult(), expected);
        assertTrue(actual.isValid());
    }

    @Test
    public void givenIncorrectPlayerInputWhenValidateThenReturnEmptyPlayerResult(){
        input = "fwhfuyewrf";
        FirstCharacterResult actual = validator.checkPlayer(input);

        assertEquals(actual.getParsedResult(), PlayerCharacter.NONE);
        assertFalse(actual.isValid());
    }

    @Test
    public void givenEmptyInputWhenValidatePlayerThenReturnEmptyPlayerResult(){
        input = "";
        FirstCharacterResult actual = validator.checkPlayer(input);

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


    @DataProvider(name = "incorrect winning condition")
    public static Object[][] incorrectWinningCondition() {
        return new Object[][]{
                {"5", new BoardDimensions(3,5)},
                {"5", new BoardDimensions(5,3)},
                {"2", new BoardDimensions(3,5)},
                {"10", new BoardDimensions(3,5)},
        };
    }

    @Test (dataProvider = "incorrect winning condition")
    public void givenWinningConditionGreaterThanBoardHeightWhenValidateThenReturnEmptyConditionResult(String winningCondition, BoardDimensions dimensions){

        WinningConditionResult result = validator.checkWinningCondition(winningCondition, dimensions);

        assertFalse(result.isValid());
    }

    @DataProvider(name = "correct winning condition")
    public static Object[][] correctWinningCondition() {
        return new Object[][]{
                {"5", new BoardDimensions(5,5)},
                {"3", new BoardDimensions(5,3)},
                {"3", new BoardDimensions(3,5)},
                {"10", new BoardDimensions(12,15)},
        };
    }

    @Test (dataProvider = "correct winning condition")
    public void givenWinningConditionSmallerThanBoardWidthWhenValidateThenReturnCorrectConditionResult(String winningCondition, BoardDimensions dimensions){
        WinningConditionResult result = validator.checkWinningCondition(winningCondition, dimensions);

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
        return new Object[]{"", " ", "bla", "\n","\t", "2 x 4", " 3xfff"} ;
    }

    @Test (dataProvider = "incorrect position input")
    public void givenIncorrectPositionInputWhenValidateThenReturnEmptyPositionResult(String incorrectInput){
        PositionResult result = validator.checkPosition(incorrectInput);

        assertFalse(result.isValid());
    }

    @DataProvider(name = "incorrect name input")
    public static Object[] incorrectNameInput() {
        return new Object[]{"", " ", "\n", "\t", "344nbhyh333"} ;
    }

    @Test (dataProvider = "incorrect name input")
    public void givenIncorrectNameInputWhenValidateThenReturnEmptyNameResult(String incorrectInput){
        PlayerResult result = validator.checkPlayerName(incorrectInput, PlayerCharacter.X);

        assertFalse(result.isValid());
    }

    @DataProvider(name = "correct name input")
    public static Object[] correctNameInput() {
        return new Object[]{"lalala", "BAAAA", "imie"} ;
    }

    @Test (dataProvider = "correct name input")
    public void givenCorrectNameInputWhenValidateThenReturnPlayerResult(String correctInput){
        PlayerResult result = validator.checkPlayerName(correctInput, PlayerCharacter.O);

        assertTrue(result.isValid());
        Player player = result.getParsedResult();
        assertEquals(player.getName(), correctInput);
    }
}