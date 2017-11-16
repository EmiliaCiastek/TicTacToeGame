package com.ciastek.tictactoegame;

import java.util.List;

public class Game {
    private PlayerCharacter currentPlayer;
    private Board board;
    private Referee referee;
    private boolean isGameWon = false;

    public Game(Board board){
        this.board = board;
        referee = new Referee(3); //TODO: get winning Condition from user
    }

    public void setFirstPlayer(PlayerCharacter player) {
        currentPlayer = player;
    }

    public PlayerCharacter getCurrentPlayer() {
        return currentPlayer;
    }

    public void play(int index) {
        board.add(index, currentPlayer);
        isGameWon = referee.isWon(board, index);
        if (isGameWon){
            System.out.println("Game over! Player " + currentPlayer + " won!!!");
        }
        switchPlayer();
    }

    private void switchPlayer() {
        //TODO (1): Players objects!

        if (currentPlayer == PlayerCharacter.O){
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
