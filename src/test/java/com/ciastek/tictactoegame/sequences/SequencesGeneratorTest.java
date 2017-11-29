package com.ciastek.tictactoegame.sequences;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SequencesGeneratorTest {
    private SequencesGenerator sequencesGenerator = new SequencesGenerator();

    @DataProvider(name = "board sizes")
    public static Object[][] generateRandomRound(){
        return new Object[][]{
                {3, 3},
                {5, 5},
                {15, 15},
                {100, 100},
                {100, 5},
                {10, 3},
                {13, 25},
                {3, 10}
        };
    }

    @Test(dataProvider = "board sizes")
    public void shouldGenerateRandomRoundSequenceWithExit(int boardWidth, int boardHeight){
        String actualSequence = sequencesGenerator.generateRandomRound(boardWidth, boardHeight);
        String expectedLastCharacter = "q";
        String[] actualSplit = actualSequence.split(System.lineSeparator());
        String actualLastChar = actualSplit[actualSplit.length -1];

        assertEquals(actualLastChar, expectedLastCharacter);
    }

    @Test(dataProvider = "board sizes")
    public void shouldGenerateHorizontalVictoryRound(int boardWidth, int boardHeight){
        String actualSequence = sequencesGenerator.generateHorizontalVictoryRound(boardWidth, boardHeight);
        String[] actualSplit = actualSequence.split(System.lineSeparator());

        int expectedWinningCondition = Math.min(boardHeight, boardWidth);
        int expectedNumberOfMoves = 2 * expectedWinningCondition - 1;

        int expectedSequenceLength = expectedNumberOfMoves + 6;

        assertEquals(actualSplit.length, expectedSequenceLength);
    }

    @Test(dataProvider = "board sizes")
    public void shouldGenerateVerticalVictoryRound(int boardWidth, int boardHeight){
        String actualSequence = sequencesGenerator.generateVerticalVictoryRound(boardWidth, boardHeight);
        String[] actualSplit = actualSequence.split(System.lineSeparator());

        int expectedWinningCondition = Math.min(boardHeight, boardWidth);
        int expectedNumberOfMoves = 2 * expectedWinningCondition - 1;

        int expectedSequenceLength = expectedNumberOfMoves + 6;

        assertEquals(actualSplit.length, expectedSequenceLength);
    }
}