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
        validateCoordinates(x, y);

        int index = (y - 1) * width + (x - 1) ;

        if (characterBoard.get(index) != PlayerCharacter.NONE) {
            throw new IllegalArgumentException("Field is already occupied");
        }

        characterBoard.set(index, character);
    }


    private void validateCoordinates(int x, int y) {     // TODO: Move to MovementValidator (with tests)
        if(x < 1 || y < 1) {
            throw new IllegalArgumentException("Coordinates have to be equals or greater than 1");
        } else if(x > width || y > height){
            throw new IllegalArgumentException("Coordinates have to be equals or smaller than board size");
        }
    }

    public PlayerCharacter getCharacterAt(int x, int y) {
        int index = (y-1) * width + (x-1);
        return characterBoard.get(index);
    }



    @Override
    public String toString() { //TODO: add row and column numbers
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if(i > 0 && i % width == 0){
                builder.append("\n");
            }

            builder.append(characterBoard.get(i))
                    .append("|");
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
}
