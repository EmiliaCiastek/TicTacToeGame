package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GameBuilderTest {

    @Test
    public void givenBoardDimensionsWhenWithBoardDimensionsThenAddDimensions(){
        GameBuilder builder = new GameBuilder();
        BoardDimensions providedDimensions = new BoardDimensions(5, 5);

        builder.withBoardDimensions(providedDimensions);

        assertEquals(builder.getBoardDimensions(), providedDimensions);
    }

    @Test
    public void givenWinningConditionWhenWithWinningConditionThenAddWinningCondition(){
        GameBuilder builder = new GameBuilder();
        WinningCondition winningCondition = new WinningCondition(4);

        builder.withWinningCondition(winningCondition);

        assertEquals(builder.getWinningCondition(), winningCondition);
    }

    @Test
    public void givenGameParametersWhenBuildReturnCorrectGame(){
        GameBuilder builder = new GameBuilder();
        WinningCondition winningCondition = new WinningCondition(4);
        BoardDimensions boardDimensions = new BoardDimensions(5, 6);

        Game game = builder.withWinningCondition(winningCondition)
                .withBoardDimensions(boardDimensions)
                .build();

        assertEquals(game.getWinningCondition(), winningCondition);
        assertEquals(game.getBoardDimensions(), boardDimensions);
    }

    @Test
    public void givenFirstPlayerWhenWithFirstPlayerThenAddFirstPlayer(){
        GameBuilder builder = new GameBuilder();
        Player oPlayer = new Player(PlayerCharacter.O, "OPlayer");
        Player xPlayer = new Player(PlayerCharacter.X, "XPlayer");
        PlayerCharacter firstPlayerCharacter = PlayerCharacter.O;
        builder.withPlayers(oPlayer, xPlayer);
        builder.withFirstPlayer(firstPlayerCharacter);

        assertEquals(builder.getFirstPlayer(), oPlayer);
    }
}