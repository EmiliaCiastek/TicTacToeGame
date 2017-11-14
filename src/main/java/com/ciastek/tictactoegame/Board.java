package com.ciastek.tictactoegame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private int width;
    private int height;
    private List<PlayerCharacter> characterBoard;
    private BoardDimensions boardDimensions;

    public Board(BoardDimensions boardDimensions){
        this.boardDimensions = boardDimensions;
        this.size = boardDimensions.getHeight() * boardDimensions.getWidth();

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

    public void add(int index, PlayerCharacter character) {
        characterBoard.set(index, character);
    }

    public PlayerCharacter getCharacterAt(int index) {
        return characterBoard.get(index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < characterBoard.size(); i++) {
            if(characterBoard.get(i) != PlayerCharacter.NONE){
                builder.append(characterBoard.get(i));
            } else {
                builder.append(i);
            }
            builder.append("|");

            if((i + 1) % boardDimensions.getWidth() == 0){
               builder.append("\n")
                       .append("------\n");
            }
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