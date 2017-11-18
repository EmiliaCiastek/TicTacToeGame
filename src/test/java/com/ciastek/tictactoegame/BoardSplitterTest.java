package com.ciastek.tictactoegame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @DataProvider(name = "main topLeft - bottomRight diagonal's indexes")
    public static Object[] mainDiagonalIndexes(){
        return new Object[] {0, 6, 12, 18, 24};
    }

    @Test (dataProvider = "main topLeft - bottomRight diagonal's indexes")
    public void givenSquareBoardThenReturnMainDiagonal(int index){
        BoardSplitter splitter = new BoardSplitter();
        BoardDimensions dimensions = new BoardDimensions(5, 5);
        Board board = new Board(dimensions);
        board.add(0, PlayerCharacter.X);
        board.add(12, PlayerCharacter.O);
        board.add(18, PlayerCharacter.X);

        List<PlayerCharacter> expectedDiagonal = new ArrayList<>();
        expectedDiagonal.add(PlayerCharacter.X);
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.O);
        expectedDiagonal.add(PlayerCharacter.X);
        expectedDiagonal.add(PlayerCharacter.NONE);

        System.out.println("expected: " + expectedDiagonal);

        List<PlayerCharacter> actualDiagonal = splitter.getTopLeftBottomRightDiagonal(board, index);
        System.out.println("actual: " + actualDiagonal);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @DataProvider(name = "below main topLeft - bottomRight diagonal's indexes")
    public static Object[][] belowMainDiagonalIndexes(){
        return new Object[][] {{5, new PlayerCharacter[]{PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.NONE}},
                {17, new PlayerCharacter[]{PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.NONE}},
                {22, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.O, PlayerCharacter.NONE}},
                {15, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.X}},
                {20, new PlayerCharacter[]{PlayerCharacter.NONE}}};
    }

    @Test (dataProvider = "below main topLeft - bottomRight diagonal's indexes")
    public void givenSquareBoardThenReturnBelowMainDiagonals(int index, PlayerCharacter[] characters){
        BoardSplitter splitter = new BoardSplitter();
        BoardDimensions dimensions = new BoardDimensions(5, 5);
        Board board = new Board(dimensions);
        board.add(5, PlayerCharacter.X);
        board.add(16, PlayerCharacter.O);
        board.add(21, PlayerCharacter.X);

        List<PlayerCharacter> expectedDiagonal = Arrays.asList(characters);
        System.out.println("expected: " + expectedDiagonal);

        List<PlayerCharacter> actualDiagonal = splitter.getTopLeftBottomRightDiagonal(board, index);
        System.out.println("actual: " + actualDiagonal);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @DataProvider(name = "above main topLeft - bottomRight diagonal's indexes")
    public static Object[][] aboveMainDiagonalIndexes(){
        return new Object[][] {{1, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.O}},
                {19, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.O}},
                {8, new PlayerCharacter[]{PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE}},
                {9, new PlayerCharacter[]{PlayerCharacter.O, PlayerCharacter.NONE}},
                {4, new PlayerCharacter[]{PlayerCharacter.X}}};
    }

    @Test (dataProvider = "above main topLeft - bottomRight diagonal's indexes")
    public void givenSquareBoardThenReturnAboveMainDiagonals(int index, PlayerCharacter[] characters){
        BoardSplitter splitter = new BoardSplitter();
        BoardDimensions dimensions = new BoardDimensions(5, 5);
        Board board = new Board(dimensions);
        board.add(2, PlayerCharacter.X);
        board.add(4, PlayerCharacter.X);
        board.add(3, PlayerCharacter.O);
        board.add(7, PlayerCharacter.X);
        board.add(19, PlayerCharacter.O);

        List<PlayerCharacter> expectedDiagonal = Arrays.asList(characters);
        System.out.println("expected: " + expectedDiagonal);

        List<PlayerCharacter> actualDiagonal = splitter.getTopLeftBottomRightDiagonal(board, index);
        System.out.println("actual: " + actualDiagonal);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

}
