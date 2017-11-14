package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BoardSplitterTest {

    private BoardSplitter splitter;

    @BeforeMethod
    public void setUp(){
        int winningCondition = 3;
        splitter = new BoardSplitter(winningCondition);
    }

    @Test
    public void shouldReturnBoardRowWhenGetRow() {
        List<PlayerCharacter> expectedRow = new ArrayList<>();
        expectedRow.add(PlayerCharacter.NONE);
        expectedRow.add(PlayerCharacter.NONE);
        expectedRow.add(PlayerCharacter.O);
        expectedRow.add(PlayerCharacter.NONE);
        expectedRow.add(PlayerCharacter.NONE);

        int boardWidth = 6;
        int boardHeight = 10;
        int x = 3;
        int y = 6;

        BoardDimensions boardDimensions = new BoardDimensions(boardWidth, boardHeight);
        Board board = new Board(boardDimensions);
        board.add(x, PlayerCharacter.O);
        int index = (y-1) * boardWidth  + (x-1); //TODO: fix adding to Board (board.add(index, PlayerCharacter) !
        assertEquals(splitter.getRow(board, index), expectedRow);
    }

   /* @Test
    public void shouldReturnBoardColumnWhenGetColumn(){
        List<PlayerCharacter> expectedColumn = new ArrayList<>();
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.O);
        expectedColumn.add(PlayerCharacter.NONE);
        expectedColumn.add(PlayerCharacter.NONE);

        Board board = new Board(10, 10);
        board.add(3, 3, PlayerCharacter.O);
        int index = 2 * 9 + 2; //TODO: fix adding to Board (board.add(index, PlayerCharacter) !
        assertEquals(splitter.getColumn(board, index), expectedColumn);

    }*/
}
