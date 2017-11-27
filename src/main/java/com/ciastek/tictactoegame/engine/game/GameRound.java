package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.movement.MovementValidator;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.victory.Referee;
import com.ciastek.tictactoegame.engine.victory.RoundResult;

import java.util.LinkedList;

public class GameRound implements Round {

    private LinkedList<Player> players;
    private Board board;
    private boolean isRoundWon;
    private Referee referee;

    public GameRound(GameSettings gameSettings) {
        board = new Board(gameSettings.getBoardDimensions());
        referee = new Referee(gameSettings.getWinningCondition());
        Player  currentPlayer = gameSettings.getFirstPlayer();
        players = new LinkedList<>();
        players.add(currentPlayer);

        players.add(gameSettings.getSecondPlayer());
    }

    public RoundResult play(int index) {
        board.add(index, getCurrentPlayer().getCharacter());

        isRoundWon = referee.isWon(board, index);
        RoundResult result = new RoundResult(isRoundWon, getCurrentPlayer());

        switchPlayer();

        return result;
    }

    public Player getCurrentPlayer() {
        return players.peek();
    }

    public String getBoardAsString() {
        return board.toString();
    }

    public Board getBoard() {
        return board;
    }

    private void switchPlayer() {
        players.add(players.poll());
    }

    public boolean isFinished() {
        return board.isFilled() || isRoundWon;
    }
}
