package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlayerTest {

    @Test
    public void whenInitializedThenCharacterSet(){
        Player player = new Player(PlayerCharacter.O);
        assertEquals(player.getCharacter(), PlayerCharacter.O);
    }
}