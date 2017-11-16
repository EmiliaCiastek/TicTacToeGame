package com.ciastek.tictactoegame;

public class Player {
    private PlayerCharacter character;
    private Game game;
    private MovementValidator validator;

    //TODO (1): add scores and name
    //TODO (2): delete game!

    public Player(PlayerCharacter character, Game game, MovementValidator validator) {
        this.character = character;
        this.game = game;
        this.validator = validator;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }

    public void move(int index) throws IllegalArgumentException {
        try {
            validator.validate(index);
            game.play(index);
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
    }
}
