package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.movement.Movement;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RoundTest {
    private Player oPlayer;
    private Player xPlayer;

    @BeforeMethod
    public void setUp(){
        oPlayer = new Player(PlayerCharacter.O);
        xPlayer = new Player(PlayerCharacter.X);
    }
}