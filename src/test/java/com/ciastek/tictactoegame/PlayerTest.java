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

        board = new Board(width, height);
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
        int x = 1;
        int y = 3;
        player.move(x, y);

        assertEquals(board.getCharacterAt(x, y), player.getCharacter());
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void givenIncorrectCoordinatesWhenPlayThenThrowException(){
        int x = 0;
        int y = 5;
        player.move(x, y);
    }
}
