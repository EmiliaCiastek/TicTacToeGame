package com.ciastek.tictactoegame;

import java.util.List;

public class BoardSplitter {

    private int winningCondition;

    public BoardSplitter(int winningCondition) {
        this.winningCondition = winningCondition;
    }

    public List<PlayerCharacter> getColumn(Board board, int index) {


        return null;
    }

    public List<PlayerCharacter> getRow(Board board, int index) {
        int startIndex = index - (winningCondition - 1);
        int endIndex = index + winningCondition;
        System.out.println(startIndex);
        System.out.println(endIndex);
        System.out.println(index);

        System.out.println(board.getCharacterBoard().subList(startIndex, endIndex));
        return board.getCharacterBoard().subList(startIndex, endIndex);
    }
}
