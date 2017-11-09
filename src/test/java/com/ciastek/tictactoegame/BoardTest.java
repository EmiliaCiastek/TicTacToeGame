package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BoardTest {
    private Board board;
    private int boardSize;

    @BeforeMethod
    public void setUpBoard(){
        boardSize = 5;
        board = new Board(boardSize);
    }

    @Test
    public void whenBoardInitializedThenSizeSet() {
        assertEquals(board.getSize(), boardSize);
    }

    @Test
    public void whenBoardInitializedThenAllFieldsNone() {
        boardSize = 3;
        board = new Board(boardSize);

        PlayerCharacter[][] expected = {{PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.NONE} ,
                {PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.NONE},
                {PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.NONE}};

        for (int i = 0; i < boardSize; i++) {
            assertEquals(board.getCharacterBoard()[i], expected[i]);
        }
    }

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Coordinates smaller than 1")
    public void givenCoordinatesSmallerThan1WhenAddThenThrowException(){
        board.add(0, 1, PlayerCharacter.X);
    }

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Coordinates greater than board size")
    public void givenCoordinatesGreaterThanBoardSizeWhenAddThenThrowException(){
        board.add(1, 9, PlayerCharacter.X);
    }

    @Test
    public void givenCorrectCoordinatesWhenAddThenAddCharacterToBoard(){
        int x = 1;
        int y = 2;
        board.add(x, y, PlayerCharacter.X);
        assertEquals(board.getCharacterBoard()[x][y], PlayerCharacter.X);
    }

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Field is already occupied")
    public void givenOccupiedCoordinatesWhenAddThenThrowException(){
        int x = 1;
        int y = 1;
        board.add(x, y, PlayerCharacter.X);
        board.add(x, y, PlayerCharacter.O);
    }


}
