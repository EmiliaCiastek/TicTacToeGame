package com.ciastek.tictactoegame.engine.player;

import com.ciastek.tictactoegame.engine.movement.Movement;
import com.ciastek.tictactoegame.engine.movement.Position;

public class Player {
    private PlayerCharacter character;
    private String name;
    private int score = 0;

    public Player(PlayerCharacter character, String name) {
        this.character = character;
        this.name = name;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }

    public Movement makeMove(Position position) {
        return new Movement(position, this.getCharacter());
    }

    public String getName() {
        return name;
    }

    public void addPoints(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }
}