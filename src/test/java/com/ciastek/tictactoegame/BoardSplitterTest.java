package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BoardSplitterTest {

    private BoardSplitter splitter;
    private Board board;


    @BeforeMethod
    public void setUp(){
        int winningCondition = 3;
        splitter = new BoardSplitter(winningCondition);
        int boardWidth = 6;
        int boardHeight = 10;

        BoardDimensions boardDimensions = new BoardDimensions(boardWidth, boardHeight);
        board = new Board(boardDimensions);
    }

    @Test
    public void shouldReturnBoardRowWhenGetRow() {
        List<PlayerCharacter> expectedRow = new ArrayList<>();
        expectedRow.add(PlayerCharacter.NONE);
        expectedRow.add(PlayerCharacter.NONE);
        expectedRow.add(PlayerCharacter.O);
        expectedRow.add(PlayerCharacter.NONE);
        expectedRow.add(PlayerCharacter.NONE);

        int index = 8;
        board.add(index, PlayerCharacter.O);

        assertEquals(splitter.getRow(board, index), expectedRow);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenStartIndexOutOfRow(){
        splitter.getRow(board,13);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenEndIndexOutOfRow(){
        splitter.getRow(board,11);
    }


    @Test (expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenStartIndexOutOfColumn(){
        splitter.getColumn(board,7);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenEndIndexOutOfColumn() {

        splitter.getColumn(board, 54);
    }

    @Test
    public void shouldReturnBoardColumnWhenGetColumn() {
        List<PlayerCharacter> expectedColumn = new ArrayList<>();
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.X);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);

        int index = 14;
        board.add(index, PlayerCharacter.X);

        System.out.println(expectedColumn);
        System.out.println(splitter.getColumn(board, index));
        assertEquals(splitter.getColumn(board, index), expectedColumn);
    }

}
