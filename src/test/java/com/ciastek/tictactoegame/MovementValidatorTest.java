package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MovementValidatorTest {
    private MovementValidator validator;
    private Board board;

    @BeforeMethod
    public void setUp(){
        int width = 4;
        int height = 3;
        board = new Board(width, height);

        validator = new MovementValidator(board);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Coordinates have to be equals or greater than 1")
    public void givenCoordinatesSmallerThan1WhenAddThenThrowException(){
        validator.validate(0, 1);
    }

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Coordinates have to be equals or smaller than board size")
    public void givenCoordinatesGreaterThanBoardSizeWhenAddThenThrowException(){
        validator.validate(1, 9);
    }

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Field is already occupied")
    public void givenOccupiedCoordinatesWhenAddThenThrowException(){

        int x = 2;
        int y = 2;
        board.add(x, y, PlayerCharacter.X);

        validator.validate(2, 2);
    }
}
