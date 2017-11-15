package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BoardSplitterTest {
    @Test
    public void shouldReturnWholeRowWhichContainsIndex(){
        BoardSplitter splitter = new BoardSplitter();
        BoardDimensions dimensions = new BoardDimensions(5, 6);
        Board board = new Board(dimensions);
        int index = 6;
        board.add(index, PlayerCharacter.X);

        List<PlayerCharacter> expectedRow = new ArrayList<>();
        expectedRow.add(PlayerCharacter.NONE);
        expectedRow.add(PlayerCharacter.X);
        expectedRow.add(PlayerCharacter.NONE);
        expectedRow.add(PlayerCharacter.NONE);
        expectedRow.add(PlayerCharacter.NONE);

        assertEquals(splitter.getRow(board, index), expectedRow);
    }

    @Test
    public void shouldReturnWholeColumnWhichContainsIndex(){
        BoardSplitter splitter = new BoardSplitter();
        BoardDimensions dimensions = new BoardDimensions(5, 6);
        Board board = new Board(dimensions);
        int index = 12;
        board.add(index, PlayerCharacter.O);

        List<PlayerCharacter> expectedColumn = new ArrayList<>();
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.O);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);

        List<PlayerCharacter> actualColumn = splitter.getColumn(board, index);

        assertEquals(actualColumn, expectedColumn);
    }

    @Test
    public void shouldReturnWholeTopBottomDiagonalWhichContainsIndex(){
        BoardSplitter splitter = new BoardSplitter();
        BoardDimensions dimensions = new BoardDimensions(5, 6);
        Board board = new Board(dimensions);
        int index = 16;
        board.add(index, PlayerCharacter.O);

        List<PlayerCharacter> expectedDiagonal = new ArrayList<>();
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.O);
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.NONE);

        List<PlayerCharacter> actualDiagonal = splitter.getTopBottomDiagonal(board, index);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @Test
    public void shouldReturnWholeBottomTopDiagonalWhichContainsIndex(){
        BoardSplitter splitter = new BoardSplitter();
        BoardDimensions dimensions = new BoardDimensions(5, 6);
        Board board = new Board(dimensions);
        int index = 19;
        board.add(index, PlayerCharacter.O);

        List<PlayerCharacter> expectedDiagonal = new ArrayList<>();
        expectedDiagonal.add(PlayerCharacter.O);
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.NONE);

        List<PlayerCharacter> actualDiagonal = splitter.getBottomTopDiagonal(board, index);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

}
