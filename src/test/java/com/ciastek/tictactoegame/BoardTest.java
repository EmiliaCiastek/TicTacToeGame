package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BoardTest {

    @Test
    public void whenBoardInitializedThenSizSet(){
        int boardSize = 3;
        Board board = new Board(boardSize);
        assertEquals(boardSize, board.getSize());
    }
}
