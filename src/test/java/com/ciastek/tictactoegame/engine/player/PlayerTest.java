package com.ciastek.tictactoegame.engine.player;

import com.ciastek.tictactoegame.engine.movement.Movement;
import com.ciastek.tictactoegame.engine.movement.Position;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void whenInitializedThenCharacterSet(){
        Player player = new Player(PlayerCharacter.O, "name");
        assertEquals(player.getCharacter(), PlayerCharacter.O);
    }

    @DataProvider(name = "Correct positions")
    public static Object[] correctPositions(){
        return new Object[] { new Position(0), new Position(8), new Position(5)};
    }

    @Test (dataProvider = "Correct positions")
    public void givenPositionWhenMakeMoveThenReturnMovement(Position position){
        Player player = new Player(PlayerCharacter.X, "name");
        Movement expectedMovement = new Movement(position, player.getCharacter());
        Movement actualMovement = player.makeMove(position);

        assertEquals(actualMovement.getPosition(), expectedMovement.getPosition());
        assertEquals(actualMovement.getCharacter(), expectedMovement.getCharacter());
    }




}