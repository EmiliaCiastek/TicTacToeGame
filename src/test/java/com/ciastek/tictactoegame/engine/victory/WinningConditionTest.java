package com.ciastek.tictactoegame.engine.victory;

import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WinningConditionTest {

    @Test
    public void givenWinningConditionWhenAsIntThenReturnIntValue(){
        int winCondition = 5;
        WinningCondition winningCondition = new WinningCondition(winCondition);

        assertEquals(winningCondition.asInt(), winCondition);
    }
}
