package com.ciastek.tictactoegame;

import java.util.ArrayList;
import java.util.List;

public class BoardSplitter {

    private int winningCondition;

    public BoardSplitter(int winningCondition) {
        this.winningCondition = winningCondition;
    }

    public List<PlayerCharacter> getColumn(Board board, int index) {
        int boardWidth = board.getBoardDimensions().getWidth();
        int startIndex = index - ((winningCondition -1) * boardWidth);
        int endIndex = index + ((winningCondition -1)* boardWidth);

        if(((startIndex) % boardWidth) != ((index )% boardWidth)){
            throw new IllegalArgumentException();
        } else if (endIndex > board.getSize()){
            throw new IllegalArgumentException();
        }
        int columnLength = winningCondition * 2 - 1;
        List<PlayerCharacter> column = new ArrayList<>();
        for (int i = 0; i < columnLength; i++) {
            column.add(board.getCharacterAt(startIndex + (i * boardWidth)));
        }

        return column;
    }

    public List<PlayerCharacter> getRow(Board board, int index) {
        int startIndex = index - (winningCondition - 1);
        int endIndex = index + winningCondition;
        int boardWidth = board.getBoardDimensions().getWidth();

        if((startIndex/boardWidth) != (index/boardWidth)){
            throw new IllegalArgumentException();
        } else if((endIndex/boardWidth) != (index/boardWidth)){
            throw new IllegalArgumentException();
        }

        return board.getCharacterBoard().subList(startIndex, endIndex);
    }

    public List<PlayerCharacter> getFirstDiagonal(Board board, int index) {
        int startIndex = index - ((winningCondition - 1) * (board.getBoardDimensions().getWidth() +1));
        int endIndex = index + ((winningCondition -1) * (board.getBoardDimensions().getWidth() +1));
        int boardWidth = board.getBoardDimensions().getWidth();

        if (startIndex < 0 ){
            throw  new IllegalArgumentException();
        } else if(endIndex % boardWidth != index % boardWidth + (winningCondition - 1)){
            throw  new IllegalArgumentException();
        }

        int diagonalLength = winningCondition * 2 - 1;
        List<PlayerCharacter> diagonal = new ArrayList<>();
        for (int i = 0; i < diagonalLength; i++) {
            diagonal.add(board.getCharacterAt(startIndex + (i * boardWidth + i)));
        }

        return diagonal;
    }


    public List<PlayerCharacter> getSecondDiagonal(Board board, int index) {
        int boardWidth = board.getBoardDimensions().getWidth();
        int startIndex = index - ((winningCondition - 1) * (board.getBoardDimensions().getWidth() -1));
        int endIndex = index + ((winningCondition - 1) * (board.getBoardDimensions().getWidth() -1));

        if(startIndex < 0){
            throw new IllegalArgumentException();
        } else if(endIndex % boardWidth != index % boardWidth - (winningCondition - 1)){
            throw  new IllegalArgumentException();
        }

        int diagonalLength = winningCondition * 2 - 1;
        List<PlayerCharacter> diagonal = new ArrayList<>();
        for (int i = 0; i < diagonalLength; i++) {
            diagonal.add(board.getCharacterAt(startIndex + (i * boardWidth - i)));
        }

        return diagonal;
    }
}
