package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.engine.board.Board;

import java.util.List;

public class Game {
    private PlayerCharacter currentPlayer;
    private Board board;
    private Referee referee;
    private boolean isGameWon = false;
    private MovementValidator validator;

    public Game(Board board) {
        this.board = board;
        referee = new Referee(new WinningCondition(3)); //TODO: get winning Condition from user
        validator = new MovementValidator(board);

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

    public List<PlayerCharacter> getBoard() {
        return board.getCharacterBoard();
    }

    public boolean isFinished() {
        return board.isFilled() || isGameWon;
    }

    public PlayerCharacter getBoardField(int index) {
        return board.getCharacterBoard().get(index);
    }
}
