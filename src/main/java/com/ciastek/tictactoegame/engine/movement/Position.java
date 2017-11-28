package com.ciastek.tictactoegame.engine.movement;

public class Position {
    private int index;

    public Position(int index){
        this.index = index;
    }

    public int asInt(){
        return index;
    }
}