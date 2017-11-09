package com.ciastek.tictactoegame;

public class Player {
    private PlayerCharacter character;
    private Game game;
    private MovementValidator validator;

    public Player(PlayerCharacter character, Game game, MovementValidator validator) {
        this.character = character;
        this.game = game;
        this.validator = validator;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }

    public void move(int x, int y) {
        try {
            validator.validate(x, y);
            game.play(x, y);
        } catch (IllegalArgumentException exception){
            throw exception;
        }
    }
}
