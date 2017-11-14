package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlayerTest {
    Player player;
    Game game;
    Board board;
    MovementValidator validator;

    @BeforeMethod
    public void setUp(){
        int width = 3;
        int height = 4;
        BoardDimensions boardDimensions = new BoardDimensions(width, height);
        board = new Board(boardDimensions);
        game = new Game(board);
        game.setFirstPlayer(PlayerCharacter.O);
        validator = new MovementValidator(board);
        player = new Player(PlayerCharacter.O, game, validator);
    }

    @Test
    public void whenInitializedThenCharacterSet(){
        assertEquals(player.getCharacter(), PlayerCharacter.O);
    }

    @Test
    public void givenCoordinatesWhenPlayThenAddedToBoard(){
        int index = 3;
        player.move(index);

        assertEquals(board.getCharacterAt(index), player.getCharacter());
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void givenIncorrectCoordinatesWhenPlayThenThrowException(){
        int index = 20;
        player.move(index);
    }
}
