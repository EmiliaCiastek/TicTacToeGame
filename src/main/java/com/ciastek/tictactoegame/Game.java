package com.ciastek.tictactoegame;

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

    public void play(int x, int y) {
        board.add(x, y, currentPlayer);

        switchPlayer();
    }

    private void switchPlayer() {
        if (currentPlayer == PlayerCharacter.O){
            currentPlayer = PlayerCharacter.X;
        } else {
            currentPlayer = PlayerCharacter.O;
        }
    }

    public PlayerCharacter[][] getBoard() {
        return board.getCharacterBoard();
    }
}
