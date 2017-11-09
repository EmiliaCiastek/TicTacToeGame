package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;


public class BoardTest {
    private Board board;
    private int boardSize;
    private int boardWidth;
    private int boardHeight;

    @BeforeMethod
    public void setUpBoard(){
        boardWidth = 3;
        boardHeight = 3;
        boardSize = boardHeight * boardWidth;
        board = new Board(boardWidth, boardHeight);
    }

    @Test
    public void whenBoardInitializedThenSizeSet() {
        assertEquals(board.getSize(), boardSize);
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
    public void givenCorrectCoordinatesWhenAddThenAddCharacterToBoard(){
        int x = 2;
        int y = 2;
        board.add(x, y, PlayerCharacter.X);
        assertEquals(board.getCharacterAt(x, y), PlayerCharacter.X);
    }

    @Test
    public void givenEmptyBoardWhenToStringThenConvertToString(){
        boardSize = 3;
        board = new Board(boardSize, boardSize);
        StringBuilder builder = new StringBuilder();
        /*builder.append("1 2 3")
                .append("1 | | \n")
                .append("------\n")
                .append("2 | | \n")
                .append("------\n")
                .append("3 | | \n")
                .append("------\n");

                */

        builder.append(" | | |\n")
                .append(" | | |\n")
                .append(" | | |");

        assertEquals(board.toString(), builder.toString());
    }

    @Test
    public void givenNotEmptyBoardWhenToStringThenConvertToString(){
        boardSize = 3;
        board = new Board(boardSize, boardSize);
        board.add(1, 1, PlayerCharacter.X);
        board.add(2, 1, PlayerCharacter.O);
        board.add(3, 2, PlayerCharacter.X);
        board.add(3, 3, PlayerCharacter.O);


        StringBuilder builder = new StringBuilder();
        builder.append("X|O| |\n")
                .append(" | |X|\n")
                .append(" | |O|");

        assertEquals(board.toString(), builder.toString());
    }

    @Test
    public void whenBoardNotFilledThenFalse(){
        board.add(2, 2, PlayerCharacter.O);
        assertFalse(board.isFilled());
    }

    @Test
    public void whenBoardFilledThenTrue(){
        //boardSize = 3;
        board = new Board(3, 3);

        board.add(1,1, PlayerCharacter.O);
        board.add(1,2, PlayerCharacter.O);
        board.add(1,3, PlayerCharacter.O);
        board.add(2,1, PlayerCharacter.O);
        board.add(2,2, PlayerCharacter.O);
        board.add(2,3, PlayerCharacter.O);
        board.add(3,1, PlayerCharacter.O);
        board.add(3,2, PlayerCharacter.O);
        board.add(3,3, PlayerCharacter.O);

        assertTrue(board.isFilled());
    }
}
