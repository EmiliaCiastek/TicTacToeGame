package com.ciastek.tictactoegame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class GameTest {
    Game game;

    @BeforeMethod
    public void setUp(){
        game = new Game();
    }


}
