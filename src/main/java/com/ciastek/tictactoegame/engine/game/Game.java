package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.events.*;
import com.ciastek.tictactoegame.engine.movement.MovementValidator;
import com.ciastek.tictactoegame.ui.PositionInput;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.victory.GameReferee;
import com.ciastek.tictactoegame.engine.victory.RoundResult;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.ui.Observer;
import com.ciastek.tictactoegame.ui.PositionResult;
import com.ciastek.tictactoegame.ui.ResultState;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Game implements Observable {
    private final int NUMBER_OF_ROUNDS = 3;
    private Round currentRound;

    private boolean isGameFinished = false;
    private GameSettings gameSettings;
    private RoundFactory factory;
    private PositionInput positionInput;
    private List<Observer> observers;
    private GameReferee gameReferee;
    private ResourceBundle resourceBundle;
    private boolean isGameExited;

    public Game(GameSettings gameSettings, RoundFactory factory, PositionInput positionInput, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        observers = new ArrayList<>();
        this.gameSettings = gameSettings;
        this.factory = factory;
        this.positionInput = positionInput;
        this.gameReferee = new GameReferee(gameSettings.getFirstPlayer(), gameSettings.getSecondPlayer(), resourceBundle);
    }

    public void play() {
        for (int roundNumber = 1; roundNumber <= NUMBER_OF_ROUNDS; roundNumber++) {
            currentRound = factory.getRound(gameSettings);
            notifyObservers(new RoundStartedEvent(resourceBundle, roundNumber));
            RoundResult roundResult = executeRound(positionInput);

            if (!isGameExited) {
                if (roundResult.isWon()) {
                    Player winner = roundResult.getWinner().get();
                    notifyObservers(new RoundEndedWithVictoryEvent(resourceBundle, winner));
                    winner.addPoints(3);
                } else {
                    notifyObservers(new RoundEndedWithDrawEvent(resourceBundle));
                    gameSettings.getFirstPlayer().addPoints(1);
                    gameSettings.getSecondPlayer().addPoints(1);
                }
            } else {
                notifyObservers(new GameLeftEvent(resourceBundle));
                break;
            }

        }
        if(!isGameExited){
            notifyObservers(new GameEndedEvent(resourceBundle, gameReferee.generateGameResult()));
        }

        isGameFinished = true;
    }

    private RoundResult executeRound(PositionInput positionInput) {
        RoundResult roundResult = new RoundResult();
        MovementValidator movementValidator = new MovementValidator(currentRound.getBoard());

        while (!currentRound.isFinished()){
            System.out.println();
            System.out.println(currentRound.getBoardAsString());

            PositionResult positionResult = positionInput.getPosition(currentRound.getCurrentPlayer());

            if(positionResult.getResultState() == ResultState.EXIT){
                isGameExited = true;
                break;
            }

            int position = positionResult.getParsedResult().asInt();

            while (!movementValidator.isValid(position)){
                notifyObservers(new IncorrectInputEvent(resourceBundle));
                positionResult = positionInput.getPosition(currentRound.getCurrentPlayer());
                if(positionResult.getResultState() == ResultState.EXIT){
                    isGameExited = true;
                    break;
                } else {
                    isGameExited = false;
                }
                position = positionResult.getParsedResult().asInt();
            }

            if(isGameExited)
                break;
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