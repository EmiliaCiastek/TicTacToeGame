package com.ciastek.tictactoegame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private int width;
    private int height;
    private List<PlayerCharacter> characterBoard;

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        this.size = width * height;
        characterBoard = new ArrayList<>();
        initializeBoard();
    }

    private void initializeBoard(){
        for (int i = 0; i < size; i++) {
          characterBoard.add(i, PlayerCharacter.NONE);
        }
    }

    public int getSize(){
        return characterBoard.size();
    }

    public List<PlayerCharacter> getCharacterBoard() {
        return characterBoard;
    }

    public void add(int x, int y, PlayerCharacter character) {
        int index = (y - 1) * width + (x - 1) ; //TODO: extract method calculateIndex() ?

        characterBoard.set(index, character);
    }

    public PlayerCharacter getCharacterAt(int x, int y) {
        int index = (y-1) * width + (x-1);
        return characterBoard.get(index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("  ");

        for (int i = 0; i < width; i++) {
            builder.append(i+1 + " ");
        }
        builder.append("\n");

        for (int i = 0; i < height; i++) {
            builder.append(i + 1 + " ");

            for (int j = 0; j < width; j++) {
                int index = (i) * width + (j) ;
                builder.append(characterBoard.get(index))
                        .append("|");
            }
            builder.append("\n")
                    .append("--------\n");
        }

        return builder.toString();
    }

    public boolean isFilled() {

        for (PlayerCharacter character : characterBoard) {
            if(character == PlayerCharacter.NONE){
                return false;
            }
        }

        return true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}