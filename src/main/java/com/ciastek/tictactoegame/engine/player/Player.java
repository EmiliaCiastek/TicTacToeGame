package com.ciastek.tictactoegame.engine.player;

import com.ciastek.tictactoegame.engine.movement.Movement;

public class Player {
    private PlayerCharacter character;
    private String name;
    private int score = 0;

    //TODO (1): add scores and name
    //TODO (2): add Movement move()

    public Player(PlayerCharacter character) {
        this.character = character;
    }

    public Player(PlayerCharacter character, String name){
        this.character = character;
        this.name = name;
    }

    public Movement move(){
        return null;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }

}
