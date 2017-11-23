package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.movement.PositionInput;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;

public class Game {
    private final int NUMBER_OF_ROUNDS = 3;
    private Round currentRound;

    private boolean isGameFinished = false;
    private GameSettings gameSettings;

    public Game(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public void play() {
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            currentRound = new Round(gameSettings);
            System.out.println("Round number " + (i + 1) + " started!");
            PositionInput positionInput = new PositionInput();

            //TODO: round.start()
            while (!currentRound.isFinished()){
                System.out.println();
                System.out.println(currentRound.getBoardAsString());
                int position = positionInput.getPosition(new Player(currentRound.getCurrentPlayer())).asInt();

                currentRound.play(position);
            }
        }
        isGameFinished = true;
    }

    public boolean isFinished() {
        return isGameFinished;
    }

    public WinningCondition getWinningCondition() {
        return gameSettings.getWinningCondition();
    }

    public BoardDimensions getBoardDimensions() {
        return gameSettings.getBoardDimensions();
    }

    public String getBoard() {
        return currentRound.getBoardAsString();
    }
}