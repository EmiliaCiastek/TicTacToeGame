package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MovementValidatorTest {
    private MovementValidator validator;
    private Board board;

    @BeforeMethod
    public void setUp(){
        int width = 4;
        int height = 3;
        BoardDimensions boardDimensions = new BoardDimensions(width, height);
        board = new Board(boardDimensions);
        validator = new MovementValidator(board);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Coordinates have to be equals or greater than 0")
    public void givenCoordinatesSmallerThan1WhenAddThenThrowException(){
        validator.validate(-1);
    }

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Coordinates have to be equals or smaller than board size")
    public void givenCoordinatesGreaterThanBoardSizeWhenAddThenThrowException(){
        validator.validate(20);
    }

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Field is already occupied")
    public void givenOccupiedCoordinatesWhenAddThenThrowException(){

        int index = 4;
        board.add(index, PlayerCharacter.X);

        validator.validate(index);
    }
}
