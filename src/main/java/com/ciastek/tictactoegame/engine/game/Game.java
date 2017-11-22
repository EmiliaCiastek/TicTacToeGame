package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.movement.MovementValidator;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.Referee;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.board.Board;

public class Game {
    private final int NUMBER_OF_ROUNDS = 3;
    private final Round round;

    private boolean isGameWon = false;
    private GameSettings gameSettings;

    public Game(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        this.round = new Round(gameSettings);
    }


    public PlayerCharacter getCurrentPlayer() {
        return round.getCurrentPlayer();
    }

    public void play(int index) {
        round.play(index);
    }

    public boolean isFinished() {
        return round.isFinished();
    }


    public WinningCondition getWinningCondition() {
        return gameSettings.getWinningCondition();
    }

    public BoardDimensions getBoardDimensions() {
        return gameSettings.getBoardDimensions();
    }

    public String getBoard() {
        return round.getBoard().toString();
    }
}
