package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.*;
import com.ciastek.tictactoegame.engine.movement.MovementValidator;
import com.ciastek.tictactoegame.engine.movement.PositionInput;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.victory.GameReferee;
import com.ciastek.tictactoegame.engine.victory.RoundResult;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;

import java.util.ArrayList;
import java.util.List;

public class Game implements Observable{
    private final int NUMBER_OF_ROUNDS = 3;
    private Round currentRound;

    private boolean isGameFinished = false;
    private GameSettings gameSettings;
    private RoundFactory factory;
    private PositionInput positionInput;
    private List<Observer> observers;
    private GameReferee gameReferee;

    public Game(GameSettings gameSettings, RoundFactory factory, PositionInput positionInput) {
        observers = new ArrayList<>();
        this.gameSettings = gameSettings;
        this.factory = factory;
        this.positionInput = positionInput;
        this.gameReferee = new GameReferee(gameSettings.getFirstPlayer(), gameSettings.getSecondPlayer());
    }

    public void play() {
        for (int roundNumber = 1; roundNumber <= NUMBER_OF_ROUNDS; roundNumber++) {
            currentRound = factory.getRound(gameSettings);
            notifyObservers(new RoundStartedEvent(roundNumber));
            RoundResult roundResult = executeRound(positionInput);

            if(roundResult.isWon()){
                Player winner = roundResult.getWinner().get();
                notifyObservers(new RoundEndedWithVictoryEvent(winner));
                winner.addPoints(3);
            } else {
                notifyObservers(new RoundEndedWithDrawEvent());
                gameSettings.getFirstPlayer().addPoints(1);
                gameSettings.getSecondPlayer().addPoints(1);
            }
        }

        notifyObservers(new GameEndedEvent(gameReferee.generateGameResult()));

        isGameFinished = true;
    }

    private RoundResult executeRound(PositionInput positionInput) {
        RoundResult roundResult = new RoundResult();
        MovementValidator movementValidator = new MovementValidator(currentRound.getBoard());

        while (!currentRound.isFinished()){
            System.out.println();
            System.out.println(currentRound.getBoardAsString());
            int position = positionInput.getPosition(currentRound.getCurrentPlayer()).asInt();

            while (!movementValidator.isValid(position)){
                System.out.println("Provided index is incorrect!"); //TODO: create Event and notify printer + detailed Message
                position = positionInput.getPosition(currentRound.getCurrentPlayer()).asInt();
            }
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