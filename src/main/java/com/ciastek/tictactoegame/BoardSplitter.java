package com.ciastek.tictactoegame;

import java.util.ArrayList;
import java.util.List;

public class BoardSplitter {

    public List<PlayerCharacter> getRow(Board board, int index) {
        int boardWidth = board.getBoardDimensions().getWidth();
        int rowNumber = getRowNumber(index, boardWidth);
        int firstIndexInRow = boardWidth * rowNumber;
        int lastIndexInRow = firstIndexInRow + boardWidth;

        return board.getCharacterBoard().subList(firstIndexInRow, lastIndexInRow);
    }

    public List<PlayerCharacter> getColumn(Board board, int index) {
        int boardHeight = board.getBoardDimensions().getHeight();
        int boardWidth = board.getBoardDimensions().getWidth();

        int columnNumber = getColumnNumber(index, boardWidth);

        int indexDelta = board.getBoardDimensions().getWidth();

        List<PlayerCharacter> column = new ArrayList<>(boardHeight);

        for (int i = 0; i < boardHeight; i++) {
            column.add(board.getCharacterAt(columnNumber + i * indexDelta));
        }

        return column;
    }



    private int getRowNumber(int index, int boardWidth){
        return index/boardWidth;
    }

    private int getColumnNumber(int index, int boardWidth){
        return index % boardWidth;
    }

    public List<PlayerCharacter> getBottomTopDiagonal(Board board, int index) {
        int boardWidth = board.getBoardDimensions().getWidth();
        int boardHeight = board.getBoardDimensions().getHeight();
        int columnNumber = getColumnNumber(index, boardWidth);

        int diagonalDelta = boardWidth - 1;
        int startIndex = index - (diagonalDelta * (Math.abs(boardWidth - columnNumber -1)));

        List<PlayerCharacter> diagonal = new ArrayList<>();

        int rowNumber = getRowNumber(startIndex, boardWidth);
        int diagonalIndex = startIndex;

        while(rowNumber < boardHeight && diagonalIndex >= 0){
            diagonal.add(board.getCharacterAt(diagonalIndex));
            diagonalIndex = diagonalIndex + diagonalDelta;
            rowNumber = getRowNumber(diagonalIndex, boardWidth);
        }
        return diagonal;
    }
    public List<PlayerCharacter> getTopBottomDiagonal(Board board, int index) {
        int boardWidth = board.getBoardDimensions().getWidth();
        int boardHeight = board.getBoardDimensions().getHeight();
        int columnNumber = getColumnNumber(index, boardWidth);

        int diagonalDelta = boardWidth + 1;
        int startIndex;
        if(getRowNumber(index, boardWidth) == 0){
            startIndex = index;
        } else {
            startIndex =  index - (diagonalDelta * columnNumber);
        }

        List<PlayerCharacter> diagonal = new ArrayList<>();

        int rowNumber = getRowNumber(startIndex, boardWidth);
        int diagonalIndex = startIndex;
        while(rowNumber < boardHeight && diagonalIndex >= 0){
            System.out.println(diagonalIndex);
            diagonal.add(board.getCharacterAt(diagonalIndex));
            diagonalIndex = diagonalIndex + diagonalDelta;
            rowNumber = getRowNumber(diagonalIndex, boardWidth);
        }

        return diagonal;
    }

    public List<PlayerCharacter> getDiagonal(Board board, int index) {
        int boardWidth = board.getBoardDimensions().getWidth();
        int diagonalIndexDelta = boardWidth + 1;
        int indexRowNumber = getRowNumber(index, boardWidth);

        int startIndex;

        if(indexRowNumber == 0){
            startIndex = index;
        } else {
            startIndex = index - (diagonalIndexDelta * indexRowNumber);
        }

        List<PlayerCharacter> diagonal = new ArrayList<>();

        int currentIndex = startIndex;

        while (currentIndex < board.getSize()){
            diagonal.add(board.getCharacterAt(currentIndex));
            currentIndex += diagonalIndexDelta;
        }
        return diagonal;
    }
}
