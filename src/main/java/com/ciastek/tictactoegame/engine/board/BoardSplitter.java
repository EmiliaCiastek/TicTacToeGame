package com.ciastek.tictactoegame.engine.board;

import com.ciastek.tictactoegame.engine.player.PlayerCharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardSplitter { //TODO: refactor

    public List<PlayerCharacter> getRow(Board board, int index) {
        int boardWidth = board.getBoardDimensions().getWidth();
        int rowNumber = getRowNumber(index, boardWidth);
        int firstIndexInRow = boardWidth * rowNumber;
        int lastIndexInRow = firstIndexInRow + boardWidth;

        return board.getCharacterBoard().subList(firstIndexInRow, lastIndexInRow);
    }

    public List<PlayerCharacter> getColumn(Board board, int index) {
        int boardHeight = board.getBoardDimensions().getHeight();
        int indexDelta = board.getBoardDimensions().getWidth();
        int columnNumber = getColumnNumber(index, indexDelta);
        List<PlayerCharacter> column = new ArrayList<>(boardHeight);

        for (int i = 0; i < boardHeight; i++) {
            column.add(board.getCharacterAt(columnNumber + i * indexDelta));
        }

        return column;
    }

    public List<PlayerCharacter> getTopLeftBottomRightDiagonal(Board board, int startIndex) {
        List<PlayerCharacter> diagonal = new ArrayList<>();

        diagonal.addAll(getElementsAboveStartIndex(board, startIndex));
        diagonal.addAll(getElementsBelowStartIndex(board, startIndex));

        return diagonal;
    }

    public List<PlayerCharacter> getTopRightBottomLeftDiagonal(Board board, int startIndex) {
        List<PlayerCharacter> diagonal = new ArrayList<>();

        int boardWidth = board.getBoardDimensions().getWidth();
        int diagonalIndexDelta = boardWidth - 1;

        int currentIndex = startIndex;
        int previousColumn = getColumnNumber(currentIndex, boardWidth);

        List<PlayerCharacter> aboveStartIndexElements = new ArrayList<>();
        while (currentIndex >= 0 && getColumnNumber(currentIndex, boardWidth) >= previousColumn) {
            aboveStartIndexElements.add(board.getCharacterAt(currentIndex));
            currentIndex -= diagonalIndexDelta;
            previousColumn++;
        }

        Collections.reverse(aboveStartIndexElements);

        diagonal.addAll(aboveStartIndexElements);

        currentIndex = startIndex + diagonalIndexDelta;
        previousColumn = getColumnNumber(startIndex, boardWidth);

        while (currentIndex < board.getSize() && getColumnNumber(currentIndex, boardWidth) <= previousColumn) {
            diagonal.add(board.getCharacterAt(currentIndex));
            currentIndex += diagonalIndexDelta;
            previousColumn--;
        }

        return diagonal;
    }

    private List<PlayerCharacter> getElementsAboveStartIndex(Board board, int currentIndex) {
        List<PlayerCharacter> aboveStartIndex = new ArrayList<>();
        int boardWidth = board.getBoardDimensions().getWidth();
        int diagonalIndexDelta = boardWidth + 1;
        int previousColumn = getColumnNumber(currentIndex, boardWidth);

        while (currentIndex >= 0 && previousColumn >= 0) {
            aboveStartIndex.add(board.getCharacterAt(currentIndex));
            previousColumn--;
            currentIndex -= diagonalIndexDelta;
        }
        Collections.reverse(aboveStartIndex);
        return aboveStartIndex;
    }

    private List<PlayerCharacter> getElementsBelowStartIndex(Board board, int startIndex) {
        List<PlayerCharacter> belowStartIndex = new ArrayList<>();
        int boardWidth = board.getBoardDimensions().getWidth();
        int diagonalIndexDelta = boardWidth + 1;
        int currentIndex = startIndex + diagonalIndexDelta;
        int previousColumn = getColumnNumber(startIndex, boardWidth);

        while (currentIndex < board.getSize() && getColumnNumber(currentIndex, boardWidth) > previousColumn) {
            belowStartIndex.add(board.getCharacterAt(currentIndex));
            previousColumn++;
            currentIndex += diagonalIndexDelta;
        }

        return belowStartIndex;
    }

    private int getRowNumber(int index, int boardWidth) {
        return index / boardWidth;
    }

    private int getColumnNumber(int index, int boardWidth) {
        return index % boardWidth;
    }
}