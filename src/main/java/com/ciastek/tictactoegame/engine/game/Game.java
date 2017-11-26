package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.GameEndedEvent;
import com.ciastek.tictactoegame.engine.events.RoundEndedWithVictoryEvent;
import com.ciastek.tictactoegame.engine.events.RoundStartedEvent;
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
    private PositionInput positionInput;
    private Printer printer;

    public Game(GameSettings gameSettings, RoundFactory fabric, PositionInput positionInput, Printer printer) {
        this.gameSettings = gameSettings;
        this.fabric = fabric;
        this.positionInput = positionInput;
        this.printer = printer;
    }

    public void play() {
        for (int roundNumber = 1; roundNumber <= NUMBER_OF_ROUNDS; roundNumber++) {
            currentRound = fabric.getRound(gameSettings);
            printer.printMessage(new RoundStartedEvent(roundNumber));

            RoundResult roundResult = executeRound(positionInput);

            if(roundResult.isWon()){
                printer.printMessage(new RoundEndedWithVictoryEvent(roundResult.getWinner().getCharacter()));
            } //TODo: RoundEndedWithDrawEvent
        }

        printer.printMessage(new GameEndedEvent());
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