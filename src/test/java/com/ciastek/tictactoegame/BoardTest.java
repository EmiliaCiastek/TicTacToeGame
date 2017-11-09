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

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Coordinates have to be equals or greater than 1")
    public void givenCoordinatesSmallerThan1WhenAddThenThrowException(){
        board.add(0, 1, PlayerCharacter.X);
    }

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Coordinates have to be equals or smaller than board size")
    public void givenCoordinatesGreaterThanBoardSizeWhenAddThenThrowException(){
        board.add(1, 9, PlayerCharacter.X);
    }

    @Test
    public void givenCorrectCoordinatesWhenAddThenAddCharacterToBoard(){
        int x = 1;
        int y = 3;
        board.add(x, y, PlayerCharacter.X);
        assertEquals(board.getCharacterBoard()[x -1][y -1], PlayerCharacter.X);
    }

    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Field is already occupied")
    public void givenOccupiedCoordinatesWhenAddThenThrowException(){
        int x = 1;
        int y = 1;
        board.add(x, y, PlayerCharacter.X);
        board.add(x, y, PlayerCharacter.O);
    }

    @Test
    public void givenEmptyBoardWhenToStringThenConvertToString(){
        boardSize = 3;
        board = new Board(boardSize);
        StringBuilder builder = new StringBuilder();
        builder.append(" | | /n")
                .append(" | | /n")
                .append(" | | /n");

        assertEquals(board.toString(), builder.toString());
    }

    @Test
    public void givenNotEmptyBoardWhenToStringThenConvertToString(){
        boardSize = 3;
        board = new Board(boardSize);
        board.add(1, 1, PlayerCharacter.X);
        board.add(2, 1, PlayerCharacter.O);
        board.add(3, 2, PlayerCharacter.X);

        StringBuilder builder = new StringBuilder();
        builder.append("X| | /n")
                .append("O| | /n")
                .append(" |X| /n");

        assertEquals(board.toString(), builder.toString());
    }

}
