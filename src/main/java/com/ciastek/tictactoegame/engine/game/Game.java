package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.BoardDimensions;
import com.ciastek.tictactoegame.engine.movement.MovementValidator;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.Referee;
import com.ciastek.tictactoegame.engine.victory.WinningCondition;
import com.ciastek.tictactoegame.engine.board.Board;

import java.util.List;

public class Game {
    private PlayerCharacter currentPlayer;
    private Board board;
    private Referee referee;
    private boolean isGameWon = false;
    private MovementValidator validator;
    private GameSettings gameSettings;

    public Game(Board board) {
        this.board = board;
        referee = new Referee(new WinningCondition(3)); //TODO: get winning Condition from user
        validator = new MovementValidator(board);
    }

    public Game(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
        board = new Board(gameSettings.getBoardDimensions());
    }

    public void setFirstPlayer(PlayerCharacter player) {
        currentPlayer = player;
    }

    public PlayerCharacter getCurrentPlayer() {
        return currentPlayer;
    }

    public void play(int index) {
        try {
            validator.validate(index);
            board.add(index, currentPlayer);
        } catch (IllegalArgumentException exception) {
            throw exception;
        }

        isGameWon = referee.isWon(board, index);
        if (isGameWon) {
            System.out.println("Game over! Player " + currentPlayer + " won!!!");
        }
        switchPlayer();
    }

    private void switchPlayer() {
        //TODO (1): Players objects!

        if (currentPlayer == PlayerCharacter.O) {
            currentPlayer = PlayerCharacter.X;
        } else {
            currentPlayer = PlayerCharacter.O;
        }
    }

    /*public List<PlayerCharacter> getBoard() {
        return board.getCharacterBoard();
    }*/
    public Board getBoard() {
        return board;
    }

    public boolean isFinished() {
        return board.isFilled() || isGameWon;
    }

    public PlayerCharacter getBoardField(int index) {
        return board.getCharacterBoard().get(index);
    }

    public WinningCondition getWinningCondition() {
        return gameSettings.getWinningCondition();
    }

    public BoardDimensions getBoardDimensions() {
        return gameSettings.getBoardDimensions();
    }
}
