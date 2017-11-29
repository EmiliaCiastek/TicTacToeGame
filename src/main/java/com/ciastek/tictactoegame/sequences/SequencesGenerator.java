package com.ciastek.tictactoegame.sequences;

import java.util.Random;

public class SequencesGenerator {


    public String generateRandomRound(int boardWidth, int boardHeight) {
        int numberOfMoves = 10;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateBeginOfSequence(boardWidth, boardHeight));

        for (int i = 0; i < numberOfMoves; i++) {
            stringBuilder.append(generateRandomMove(numberOfMoves))
                    .append(System.lineSeparator());
        }

        stringBuilder.append("q");

        return stringBuilder.toString();
    }

    private int generateRandomMove(int size){
        Random random = new Random();
        return random.nextInt(size);
    }

    public String generateHorizontalVictoryRound(int boardWidth, int boardHeight) {
        int winningCondition = Math.min(boardWidth, boardHeight);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateBeginOfSequence(boardWidth, boardHeight));

        int numberOfMoves = winningCondition * 2 -1;
        int position = 0;
        int previousPosition =position;

        stringBuilder.append((position))
                .append(System.lineSeparator());

        for (int i = 1; i < numberOfMoves; i++) {

            if(i%2== 0){
                position = previousPosition+ 1;
                previousPosition = position;
            } else {
                position += boardWidth;
            }

            stringBuilder.append((position))
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    public String generateVerticalVictoryRound(int boardWidth, int boardHeight) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateBeginOfSequence(boardWidth, boardHeight));

        int winningCondition = Math.min(boardWidth, boardHeight);
        int numberOfMoves = winningCondition * 2 -1;
        int position = 0;
        int previousPosition =position;

        stringBuilder.append((position))
                .append(System.lineSeparator());

        for (int i = 1; i < numberOfMoves; i++) {

            if(i%2== 0){
                position = previousPosition + boardWidth ;
                previousPosition = position;
            } else {
                position = previousPosition + 1;
            }

            stringBuilder.append((position))
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    private String generateBeginOfSequence(int boardWidth, int boardHeight){
        String boardSize = "%sx%s";
        int winningCondition = Math.min(boardWidth, boardHeight);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EN")
                .append(System.lineSeparator())
                .append("OPlayerName")
                .append(System.lineSeparator())
                .append("XPlayerName")
                .append(System.lineSeparator())
                .append(String.format(boardSize, boardWidth, boardHeight))
                .append(System.lineSeparator())
                .append(winningCondition)
                .append(System.lineSeparator())
                .append("O")
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }
}
