package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.ui.InputReader;
import com.ciastek.tictactoegame.ui.InputValidator;
import com.ciastek.tictactoegame.ui.PositionResult;

import java.util.Scanner;

public class PositionScannerInput implements PositionInput{


    private final InputReader inputReader;

    public PositionScannerInput(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Position getPosition(Player player){
        System.out.println("Player: " + player.getCharacter() + " turn");

        InputValidator inputValidator = new InputValidator();
        System.out.println("Provide position: ");
        //Scanner indexInput = new Scanner(System.in);

        PositionResult positionResult = inputValidator.checkPosition(inputReader.readInput());
        while (!positionResult.isValid()) {
            System.out.println("Provided index is incorrect. Index has to be a number");
            positionResult = inputValidator.checkPosition(inputReader.readInput());
        }

        return positionResult.getParsedResult();
    }
}
