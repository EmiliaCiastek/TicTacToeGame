package com.ciastek.tictactoegame.ui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class GameUITest {
    @DataProvider(name = "game sequences")
    public static Object[][] gameSequences(){
        return new Object[][]{
                {"PlayerO\nPlayerX\n3x3\n3\nO\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6", "And the winner is.... " + "PlayerO! O:9, X:0"},
                {"PlayerO\nPlayerX\n3x3\n3\nX\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6\n0\n1\n2\n3\n4\n5\n6", "And the winner is.... " + "PlayerX! X:9, O:0"},
                {"PlayerO\nPlayerX\n3x3\n3\nO\n0\n1\n4\n2\n5\n3\n6\n8\n7\n0\n1\n4\n2\n5\n3\n6\n8\n7\n0\n1\n4\n2\n5\n3\n6\n8\n7", "Game ended with draw! O:3, X:3"}
        };
    }

    @Test(dataProvider = "game sequences")
    public void givenInputSequenceThenShouldDisplayGameOverMessage(String gameSequence, String expectedGameResult){
        System.setIn(new ByteArrayInputStream(gameSequence.getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        GameUI.main(new String[]{});
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        List<String> gameOutput = Arrays.asList(byteArrayOutputStream.toString().split("\n"));

        String actualLastLine = gameOutput.get(gameOutput.size() -1);

        assertEquals(actualLastLine, expectedGameResult);
    }

}