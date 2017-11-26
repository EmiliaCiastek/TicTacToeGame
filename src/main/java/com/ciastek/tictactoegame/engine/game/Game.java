package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.RoundEndedWithVictoryEvent;
import com.ciastek.tictactoegame.engine.movement.PositionInput;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.victory.RoundResult;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.ui.Printer;

public class Game {
    private final int NUMBER_OF_ROUNDS = 3;
    private Round currentRound;

    private boolean isGameFinished = false;
    private GameSettings gameSettings;
    private RoundFactory fabric;

    public Game(GameSettings gameSettings, RoundFactory fabric) {
        this.gameSettings = gameSettings;
        this.fabric = fabric;
    }

    public void play() {
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            currentRound = fabric.getRound(gameSettings);
            System.out.println("Round number " + (i + 1) + " started!");
            PositionInput positionInput = new PositionInput();

            //TODO: round.start()
            RoundResult roundResult = executeRound(positionInput);

            if(roundResult.isWon()){
                Printer printer = new Printer();
                printer.printMessage(new RoundEndedWithVictoryEvent(roundResult.getWinner().getCharacter()));
            } //TODo: RoundEndedWithDrawEvent

        }
        isGameFinished = true;
    }

    private RoundResult executeRound(PositionInput positionInput) {
        RoundResult roundResult = new RoundResult();

        while (!currentRound.isFinished()){
            System.out.println();
            System.out.println(currentRound.getBoardAsString());
            int position = positionInput.getPosition(new Player(currentRound.getCurrentPlayer())).asInt();

            roundResult = currentRound.play(position);
        }

        return roundResult;
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