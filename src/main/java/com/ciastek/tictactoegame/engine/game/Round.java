package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.board.Board;
import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.engine.victory.RoundResult;

public interface Round {

    RoundResult play(int index);
    Player getCurrentPlayer();
    String getBoardAsString();
    boolean isFinished();
    Board getBoard();
}