package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MovementValidatorTest {
    private MovementValidator validator;
    private Board board;

    @BeforeMethod
    public void setUp() {
        int width = 4;
        int height = 3;
        BoardDimensions boardDimensions = new BoardDimensions(width, height);
        board = new Board(boardDimensions);
        validator = new MovementValidator(board);
    }

    @DataProvider(name = "indices out of bound")
    public static Object[] indicesOutOfBounds() {
        return new Object[]{-1, -100, -5, 55, 12, 34};
    }

    @Test(dataProvider = "indices out of bound")
    public void givenOutOfBoundIndicesWhenIsValidThenReturnFalse(int incorrectIndex) {
        assertEquals(validator.isValid(incorrectIndex), ValidationState.OUT_OF_BOUNDS);
    }

    @DataProvider(name = "correct indices")
    public static Object[] correctIndices() {
        return new Object[]{0, 1, 11, 10, 5, 4};
    }

    @Test(dataProvider = "correct indices")
    public void givenCorrectIndicesWhenIsValidThenReturnTrue(int correctIndex) {
        assertEquals(validator.isValid(correctIndex), ValidationState.VALID);
    }

    @DataProvider(name = "occupied indices")
    public static Object[] occupiedIndices() {
        return new Object[]{0, 1, 11, 10, 5, 4};
    }

    @Test(dataProvider = "occupied indices")
    public void givenOccupiedIndicesWhenIsValidThenReturnFalse(int occupiedIndex) {
        board.add(occupiedIndex, PlayerCharacter.X);

        assertEquals(validator.isValid(occupiedIndex), ValidationState.OCCUPIED);
    }
}