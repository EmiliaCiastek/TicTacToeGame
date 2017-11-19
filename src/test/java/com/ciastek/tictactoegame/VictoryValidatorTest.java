package com.ciastek.tictactoegame;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class VictoryValidatorTest {


    @Test
    public void givenNoVictoryThenFalse(){
        VictoryValidator victory = new VictoryValidator(new WinningCondition(3));

        List<PlayerCharacter> boardPiece = new ArrayList<>();
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.X);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.O);
        boardPiece.add(PlayerCharacter.NONE);

        assertFalse(victory.isVictory(boardPiece));
    }

    @Test
    public void givenXVictoryThenTrue(){
        VictoryValidator victory = new VictoryValidator(new WinningCondition(4));

        List<PlayerCharacter> boardPiece = new ArrayList<>();
        boardPiece.add(PlayerCharacter.O);
        boardPiece.add(PlayerCharacter.X);
        boardPiece.add(PlayerCharacter.X);
        boardPiece.add(PlayerCharacter.X);
        boardPiece.add(PlayerCharacter.X);
        boardPiece.add(PlayerCharacter.NONE);

        assertTrue(victory.isVictory(boardPiece));
    }

    @Test
    public void givenNoVictoryWithNoneThenFalse(){
        VictoryValidator victory = new VictoryValidator(new WinningCondition(3));
        List<PlayerCharacter> boardPiece = new ArrayList<>();
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);
        boardPiece.add(PlayerCharacter.NONE);

        assertFalse(victory.isVictory(boardPiece));
    }

}
