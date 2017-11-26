package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.GameEndedEvent;
import com.ciastek.tictactoegame.engine.events.GameEvent;
import com.ciastek.tictactoegame.engine.events.RoundEndedWithVictoryEvent;
import com.ciastek.tictactoegame.engine.events.RoundStartedEvent;
import com.ciastek.tictactoegame.engine.movement.PositionInput;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.RoundResult;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.ui.Printer;

import java.util.ArrayList;
import java.util.List;

public class Game implements Observable{
    private final int NUMBER_OF_ROUNDS = 3;
    private Round currentRound;

    private boolean isGameFinished = false;
    private GameSettings gameSettings;
    private RoundFactory fabric;
    private PositionInput positionInput;
    private List<Observer> observers;

    public Game(GameSettings gameSettings, RoundFactory fabric, PositionInput positionInput) {
        observers = new ArrayList<>();
        this.gameSettings = gameSettings;
        this.fabric = fabric;
        this.positionInput = positionInput;
    }

    public void play() {
        for (int roundNumber = 1; roundNumber <= NUMBER_OF_ROUNDS; roundNumber++) {
            currentRound = fabric.getRound(gameSettings);
            notifyObservers(new RoundStartedEvent(roundNumber));
            RoundResult roundResult = executeRound(positionInput);

            if(roundResult.isWon()){
                Player winner = roundResult.getWinner().get();
                PlayerCharacter winnerCharacter = winner.getCharacter();
                notifyObservers(new RoundEndedWithVictoryEvent(winnerCharacter));
            } //TODo: RoundEndedWithDrawEvent
        }

        notifyObservers(new GameEndedEvent());
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

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(GameEvent event) {
        for (Observer observer : observers) {
            observer.notify(event);
        }
    }
}