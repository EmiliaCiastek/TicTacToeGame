package com.ciastek.tictactoegame.engine.board;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BoardSplitterTest {
    BoardSplitter splitter = new BoardSplitter();

    @Test
    public void shouldReturnWholeRowWhichContainsIndex(){
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
        //Given:
        BoardDimensions dimensions = new BoardDimensions(5, 6);
        Board board = new Board(dimensions);
        int index = 12;
        board.add(index, PlayerCharacter.O);

        //When:
        List<PlayerCharacter> actualColumn = splitter.getColumn(board, index);

        //Then:
        List<PlayerCharacter> expectedColumn = new ArrayList<>();
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.O);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);

        assertEquals(actualColumn, expectedColumn);
    }

    @DataProvider(name = "main topLeft - bottomRight diagonal's indexes")
    public static Object[] mainTopLeftBottomRightDiagonalIndexes(){
        return new Object[] {0, 6, 12, 18, 24};
    }

    @Test (dataProvider = "main topLeft - bottomRight diagonal's indexes")
    public void givenSquareBoardThenReturnMainTopLeftBottomRightDiagonal(int index){
        //Given:
        BoardDimensions dimensions = new BoardDimensions(5, 5);
        Board board = new Board(dimensions);
        board.add(0, PlayerCharacter.X);
        board.add(12, PlayerCharacter.O);
        board.add(18, PlayerCharacter.X);

        //When:
        List<PlayerCharacter> actualDiagonal = splitter.getTopLeftBottomRightDiagonal(board, index);

        //Then:
        List<PlayerCharacter> expectedDiagonal = new ArrayList<>();
        expectedDiagonal.add(PlayerCharacter.X);
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.O);
        expectedDiagonal.add(PlayerCharacter.X);
        expectedDiagonal.add(PlayerCharacter.NONE);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @DataProvider(name = "below main topLeft - bottomRight diagonal's indexes")
    public static Object[][] belowMainTopLeftBottomRightDiagonalIndexes(){
        return new Object[][] {{5, new PlayerCharacter[]{PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.NONE}},
                {17, new PlayerCharacter[]{PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.NONE}},
                {22, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.O, PlayerCharacter.NONE}},
                {15, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.X}},
                {20, new PlayerCharacter[]{PlayerCharacter.NONE}}};
    }

    @Test (dataProvider = "below main topLeft - bottomRight diagonal's indexes")
    public void givenSquareBoardThenReturnBelowTopLeftBottomRightMainDiagonals(int index, PlayerCharacter[] characters){
       //Given
        BoardDimensions dimensions = new BoardDimensions(5, 5);
        Board board = new Board(dimensions);
        board.add(5, PlayerCharacter.X);
        board.add(16, PlayerCharacter.O);
        board.add(21, PlayerCharacter.X);

        //When:
        List<PlayerCharacter> actualDiagonal = splitter.getTopLeftBottomRightDiagonal(board, index);

        //Then:
        List<PlayerCharacter> expectedDiagonal = Arrays.asList(characters);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @DataProvider(name = "above main topLeft - bottomRight diagonal's indexes")
    public static Object[][] aboveMainTopLeftBottomRightDiagonalIndexes(){
        return new Object[][] {{1, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.O}},
                {19, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.O}},
                {8, new PlayerCharacter[]{PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE}},
                {9, new PlayerCharacter[]{PlayerCharacter.O, PlayerCharacter.NONE}},
                {4, new PlayerCharacter[]{PlayerCharacter.X}}};
    }

    @Test (dataProvider = "above main topLeft - bottomRight diagonal's indexes")
    public void givenSquareBoardThenReturnAboveTopLeftBottomRightMainDiagonals(int index, PlayerCharacter[] characters){
        //Given:
        BoardDimensions dimensions = new BoardDimensions(5, 5);
        Board board = new Board(dimensions);
        board.add(2, PlayerCharacter.X);
        board.add(4, PlayerCharacter.X);
        board.add(3, PlayerCharacter.O);
        board.add(7, PlayerCharacter.X);
        board.add(19, PlayerCharacter.O);

        //When:
        List<PlayerCharacter> actualDiagonal = splitter.getTopLeftBottomRightDiagonal(board, index);

        //Then:
        List<PlayerCharacter> expectedDiagonal = Arrays.asList(characters);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @DataProvider(name = "main topRight - bottomLeft diagonal's indexes")
    public static Object[] mainTopRightBottomLeftDiagonalIndexes(){
        return new Object[] {4, 8, 12, 16, 20};
    }

    @Test (dataProvider = "main topRight - bottomLeft diagonal's indexes")
    public void givenSquareBoardThenReturnMainTopRightBottomLeftDiagonal(int index){
        //Given:
        BoardDimensions dimensions = new BoardDimensions(5, 5);
        Board board = new Board(dimensions);
        board.add(4, PlayerCharacter.X);
        board.add(12, PlayerCharacter.O);
        board.add(20, PlayerCharacter.X);

        //When:
        List<PlayerCharacter> actualDiagonal = splitter.getTopRightBottomLeftDiagonal(board, index);

        //Then:
        List<PlayerCharacter> expectedDiagonal = new ArrayList<>();
        expectedDiagonal.add(PlayerCharacter.X);
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.O);
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.X);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @DataProvider(name = "below main topRight - bottomLeft diagonal's indexes")
    public static Object[][] belowTopRightBottomLeftMainDiagonalIndexes(){
        return new Object[][] {{9, new PlayerCharacter[]{PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.NONE}},
                {17, new PlayerCharacter[]{PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE, PlayerCharacter.NONE}},
                {18, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.O, PlayerCharacter.NONE}},
                {23, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.X}},
                {24, new PlayerCharacter[]{PlayerCharacter.NONE}}};
    }

    @Test (dataProvider = "below main topRight - bottomLeft diagonal's indexes")
    public void givenSquareBoardThenReturnBelowTopRightBottomLeftMainDiagonals(int index, PlayerCharacter[] characters){
        //Given:
        BoardDimensions dimensions = new BoardDimensions(5, 5);
        Board board = new Board(dimensions);
        board.add(9, PlayerCharacter.X);
        board.add(18, PlayerCharacter.O);
        board.add(23, PlayerCharacter.X);
        //When:
        List<PlayerCharacter> actualDiagonal = splitter.getTopRightBottomLeftDiagonal(board, index);

        //Then:
        List<PlayerCharacter> expectedDiagonal = Arrays.asList(characters);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @DataProvider(name = "above main topRight - bottomLeft diagonal's indexes")
    public static Object[][] aboveTopRightBottomLeftMainDiagonalIndexes(){
        return new Object[][] {{3, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.O}},
                {15, new PlayerCharacter[]{PlayerCharacter.NONE, PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.O}},
                {6, new PlayerCharacter[]{PlayerCharacter.X, PlayerCharacter.NONE, PlayerCharacter.NONE}},
                {5, new PlayerCharacter[]{PlayerCharacter.O, PlayerCharacter.NONE}},
                {0, new PlayerCharacter[]{PlayerCharacter.X}}};
    }

    @Test (dataProvider = "above main topRight - bottomLeft diagonal's indexes")
    public void givenSquareBoardThenReturnAboveTopRightBottomLeftMainDiagonals(int index, PlayerCharacter[] characters){
        //Given:
        BoardDimensions dimensions = new BoardDimensions(5, 5);
        Board board = new Board(dimensions);
        board.add(0, PlayerCharacter.X);
        board.add(1, PlayerCharacter.O);
        board.add(2, PlayerCharacter.X);
        board.add(7, PlayerCharacter.X);
        board.add(15, PlayerCharacter.O);

        //When:
        List<PlayerCharacter> actualDiagonal = splitter.getTopRightBottomLeftDiagonal(board, index);

        //Then:
        List<PlayerCharacter> expectedDiagonal = Arrays.asList(characters);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @Test
    public void givenRectangularBoardThenReturnCorrectTopLeftDiagonal(){
        //Given:
        BoardDimensions dimensions = new BoardDimensions(4, 10);
        Board board = new Board(dimensions);
        board.add(4, PlayerCharacter.X);
        board.add(1, PlayerCharacter.O);
        board.add(18, PlayerCharacter.X);
        board.add(14, PlayerCharacter.O);
        board.add(19, PlayerCharacter.O);

        //When:
        List<PlayerCharacter> actualDiagonal = splitter.getTopLeftBottomRightDiagonal(board, 19);

        //Then:
        List<PlayerCharacter> expectedDiagonal = new ArrayList<>();
        expectedDiagonal.add(PlayerCharacter.X);
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.O);
        expectedDiagonal.add(PlayerCharacter.O);

        assertEquals(actualDiagonal, expectedDiagonal);
    }

    @Test
    public void givenRectangularBoardThenReturnCorrectTopRightDiagonal(){
        //Given:
        BoardDimensions dimensions = new BoardDimensions(10, 4);
        Board board = new Board(dimensions);
        board.add(4, PlayerCharacter.X);
        board.add(14, PlayerCharacter.O);
        board.add(32, PlayerCharacter.X);
        board.add(14, PlayerCharacter.O);
        board.add(19, PlayerCharacter.O);

        //When:
        List<PlayerCharacter> actualDiagonal = splitter.getTopRightBottomLeftDiagonal(board, 5);

        //Then:
        List<PlayerCharacter> expectedDiagonal = new ArrayList<>();
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.O);
        expectedDiagonal.add(PlayerCharacter.NONE);
        expectedDiagonal.add(PlayerCharacter.X);

        assertEquals(actualDiagonal, expectedDiagonal);
    }
}
