package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.events.RoundEndedWithVictoryEvent;
import com.ciastek.tictactoegame.engine.movement.MovementValidator;
import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.Referee;
import com.ciastek.tictactoegame.ui.Printer;

import java.util.LinkedList;

public class Round {
    private LinkedList<PlayerCharacter> players;
    private Board board;
    private boolean isRoundWon;
    private Referee referee;

    public Round(GameSettings gameSettings) {
        board = new Board(gameSettings.getBoardDimensions());
        referee = new Referee(gameSettings.getWinningCondition());
        PlayerCharacter  currentPlayer = gameSettings.getFirstPlayer();
        players = new LinkedList<>();
        players.add(currentPlayer);

        PlayerCharacter secondPlayer = currentPlayer == PlayerCharacter.O ? PlayerCharacter.X : PlayerCharacter.O;
        players.add(secondPlayer);
    }

    public void play(int index) {
        try {
            MovementValidator validator = new MovementValidator(board);
            validator.validate(index);
            board.add(index, getCurrentPlayer());
        } catch (IllegalArgumentException exception) {
            throw exception;
        }

        isRoundWon = referee.isWon(board, index);

        if(isRoundWon){
            Printer printer = new Printer();
            printer.printMessage(new RoundEndedWithVictoryEvent(getCurrentPlayer()));
        }

        switchPlayer();

    }

    public PlayerCharacter getCurrentPlayer() {
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

    public boolean isRoundWon() {
        return isRoundWon;
    }
}
