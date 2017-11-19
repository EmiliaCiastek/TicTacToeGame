package com.ciastek.tictactoegame;

public class Player {
    private PlayerCharacter character;

    //TODO (1): add scores and name
    //TODO (2): add Movement move()

    public Player(PlayerCharacter character) {
        this.character = character;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }

}
