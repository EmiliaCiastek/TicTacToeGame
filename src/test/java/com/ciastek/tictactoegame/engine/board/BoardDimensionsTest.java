package com.ciastek.tictactoegame.engine.board;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BoardDimensionsTest {

    @Test
    public void shouldReturnWidthWhenGetWidth(){
        int width = 10;
        int height = 12;
        BoardDimensions dimensions = new BoardDimensions(width, height);

        assertEquals(dimensions.getWidth(), width);
    }

    @Test
    public void shouldReturnHeightWhenGetHeight(){
        int width = 10;
        int height = 12;
        BoardDimensions dimensions = new BoardDimensions(width, height);

        assertEquals(dimensions.getHeight(), height);
    }
}
