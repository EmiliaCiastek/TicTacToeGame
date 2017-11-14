package com.ciastek.tictactoegame;

import java.util.List;

public class Game {
    private PlayerCharacter currentPlayer;
    private Board board;

    public Game(Board board){
        this.board = board;
    }

    public void setFirstPlayer(PlayerCharacter player) {
        currentPlayer = player;
    }

    public PlayerCharacter getCurrentPlayer() {
        return currentPlayer;
    }

    public void play(int index) { //TODO: fix play method: x y -> index
        board.add(index, currentPlayer);

        switchPlayer();
    }

    private void switchPlayer() {
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
        return board.isFilled();
    }

    public PlayerCharacter getBoardField(int index) {
        return board.getCharacterBoard().get(index);
    }
}
