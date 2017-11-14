package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BoardTest {
    private Board board;
    private BoardDimensions boardDimensions;
    private int boardSize;

    @BeforeMethod
    public void setUpBoard() {
        boardDimensions = new BoardDimensions(10, 12);
        board = new Board(boardDimensions);
        boardSize = boardDimensions.getHeight() * boardDimensions.getWidth();
    }

    @Test
    public void whenBoardInitializedThenSizeSet() {
        int expectedSize = boardDimensions.getWidth() * boardDimensions.getHeight();

        assertEquals(board.getSize(), expectedSize);
    }

    @Test
    public void whenBoardInitializedThenAllFieldsNone() {
        List<PlayerCharacter> expected = new ArrayList<>(boardSize);
        for (int i = 0; i < boardSize; i++) {
            expected.add(i, PlayerCharacter.NONE);
        }

        assertEquals(board.getCharacterBoard(), expected);
    }


    @Test
    public void givenCorrectCoordinatesWhenAddThenAddCharacterToBoard() {
        int index = 4;
        board.add(4, PlayerCharacter.X);
        assertEquals(board.getCharacterAt(4), PlayerCharacter.X);
    }



    @Test
    public void givenEmptyBoardWhenToStringThenConvertToString() {
        boardSize = 3;
        boardDimensions = new BoardDimensions(boardSize, boardSize);
        board = new Board(boardDimensions);
        StringBuilder builder = new StringBuilder();


        builder.append("0|1|2|\n")
                .append("------\n")
                .append("3|4|5|\n")
                .append("------\n")
                .append("6|7|8|\n")
                .append("------\n");

        assertEquals(board.toString(), builder.toString());
    }

    @Test
    public void givenNotEmptyBoardWhenToStringThenConvertToString() {
        boardSize = 3;
        boardDimensions = new BoardDimensions(boardSize, boardSize);
        board = new Board(boardDimensions);
        board.add(0, PlayerCharacter.X);
        board.add(1, PlayerCharacter.O);
        board.add(5, PlayerCharacter.X);
        board.add(8, PlayerCharacter.O);


        StringBuilder builder = new StringBuilder();
        builder.append("X|O|2|\n")
                .append("------\n")
                .append("3|4|X|\n")
                .append("------\n")
                .append("6|7|O|\n")
                .append("------\n");

        assertEquals(board.toString(), builder.toString());
    }

    @Test
    public void whenBoardNotFilledThenFalse() {
        board.add(4, PlayerCharacter.O);
        assertFalse(board.isFilled());
    }



    @Test
    public void whenBoardFilledThenTrue() {
        boardSize = 3;
        boardDimensions = new BoardDimensions(boardSize, boardSize);
        board = new Board(boardDimensions);

        board.add(0, PlayerCharacter.O);
        board.add(1, PlayerCharacter.O);
        board.add(2, PlayerCharacter.O);
        board.add(3, PlayerCharacter.O);
        board.add(4, PlayerCharacter.O);
        board.add(5, PlayerCharacter.O);
        board.add(6, PlayerCharacter.O);
        board.add(7, PlayerCharacter.O);
        board.add(8, PlayerCharacter.O);

        assertTrue(board.isFilled());
    }

}
