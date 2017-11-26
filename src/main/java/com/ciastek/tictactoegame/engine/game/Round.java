package com.ciastek.tictactoegame.engine.game;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;
import com.ciastek.tictactoegame.engine.victory.RoundResult;

public interface Round {

    RoundResult play(int index);

    PlayerCharacter getCurrentPlayer();

    String getBoardAsString();

    boolean isFinished();

}
