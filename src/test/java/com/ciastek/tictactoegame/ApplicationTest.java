package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.sequences.SequencesGenerator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.assertEquals;

public class ApplicationTest {
    @DataProvider(name = "game sequences")
    public static Object[][] gameSequences() {
        return new Object[][]{
                {"EN\nPlayerO\nPlayerX\n3x3\n3\nO\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6", "And the winner is.... " + "PlayerO! O:9, X:0"},
                {"eN\nPlayerO\nPlayerX\n3x3\n3\nX\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6", "And the winner is.... " + "PlayerX! X:9, O:0"},
                {"En\nPlayerO\nPlayerX\n3x3\n3\nO\n0\n1\n4\n2\n5\n3\n6\n8\n7\n0\n1\n4\n2\n5\n3\n6\n8\n7\n0\n1\n4\n2\n5\n3\n6\n8\n7", "Game ended with draw! O:3, X:3"},
                {"PL\nPlayerO\nPlayerX\n3x3\n3\nO\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6", "Zwyciezyl... " + "PlayerO! O:9, X:0"},
                {"Pl\nPlayerO\nPlayerX\n3x3\n3\nX\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6", "Zwyciezyl... " + "PlayerX! X:9, O:0"},
                {"pl\nPlayerO\nPlayerX\n3x3\n3\nO\n0\n1\n4\n2\n5\n3\n6\n8\n7\n0\n1\n4\n2\n5\n3\n6\n8\n7\n0\n1\n4\n2\n5\n3\n6\n8\n7", "Gra zakonczona remisem! O:3, X:3"},
                {"pL\nPlayerO\nPlayerX\n3x3\n3\nO\n0\nq", "Wyszedles z gry :("},
                {"en\nPlayerO\nPlayerX\n3x3\n3\nO\n0\nq", "You left the game :("}
        };
    }

    @Test(dataProvider = "game sequences")
    public void givenInputSequenceThenShouldDisplayGameOverMessage(String gameSequence, String expectedGameResult) {
        System.setIn(new ByteArrayInputStream(gameSequence.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        Application.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        List<String> gameOutput = Arrays.asList(byteArrayOutputStream.toString().split(System.lineSeparator()));

        String actualLastLine = gameOutput.get(gameOutput.size() - 1);

        assertEquals(actualLastLine, expectedGameResult);
    }

    @DataProvider(name = "random sequences")
    public static Object[] generatedSingleRoundSequences() {
        SequencesGenerator sequencesGenerator = new SequencesGenerator();
        int numberOfTests = 15;
        Object[] result = new Object[numberOfTests];

        for (int i = 0; i < numberOfTests; i++) {
            int width = ThreadLocalRandom.current().nextInt(3, 50);
            int height = ThreadLocalRandom.current().nextInt(3, 50);

            result[i] = sequencesGenerator.generateRandomRound(width, height);
        }
        return result;
    }

    @Test(dataProvider = "random sequences")
    public void givenRandomRoundSequenceWithExitThenShouldDisplayLeftGameMessage(String gameSequence) {
        String expectedGameResult = "You left the game :(";
        System.setIn(new ByteArrayInputStream(gameSequence.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        Application.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        List<String> gameOutput = Arrays.asList(byteArrayOutputStream.toString().split(System.lineSeparator()));

        String actualLastLine = gameOutput.get(gameOutput.size() - 1);

        assertEquals(actualLastLine, expectedGameResult);
    }

    @DataProvider(name = "horizontal winning sequences")
    public static Object[][] generatedHorizontalSequences() {
        SequencesGenerator sequencesGenerator = new SequencesGenerator();
        int numberOfTests = 15;
        Object[][] result = new Object[numberOfTests][2];

        for (int i = 0; i < numberOfTests; i++) {
           int width = ThreadLocalRandom.current().nextInt(3, 50);
          int height = ThreadLocalRandom.current().nextInt(3, 50);

            result[i][0] = sequencesGenerator.generateHorizontalVictoryRound(width, height) + "q";
            result[i][1] = height;
        }

        return result;
    }

    @Test(dataProvider = "horizontal winning sequences")
    public void givenHorizontalVictoryRoundSequenceWithExitThenShouldDisplayPlayerOWonRoundAndLeftGameMessage(String gameSequence, int height) {
        String[] expectedGameResult = {"Round over! Player O won! Congratulations OPlayerName!", "You left the game :("};
        System.setIn(new ByteArrayInputStream(gameSequence.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        Application.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        List<String> gameOutput = Arrays.asList(byteArrayOutputStream.toString().split(System.lineSeparator()));

        int resultLineIdx = gameOutput.size() - (7 + (2* height)); // Lines displayed between round result message and first possible input

        String actual = gameOutput.get(resultLineIdx);
        String[] actualLastLines = {actual ,gameOutput.get(gameOutput.size() - 1)};

        assertEquals(actualLastLines, expectedGameResult);
    }
}