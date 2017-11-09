package com.ciastek.tictactoegame;

public enum PlayerCharacter {
    X ("X"),
    O ("O"),
    NONE (" ");

    private final String value;

    PlayerCharacter(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }


}
