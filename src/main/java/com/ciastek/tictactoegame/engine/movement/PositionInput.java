package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.ui.InputValidator;
import com.ciastek.tictactoegame.ui.PositionResult;

import java.util.Scanner;

public class PositionInput {

    public Position getPosition(Player player){
        System.out.println("Player: " + player.getCharacter() + " turn");

        InputValidator inputValidator = new InputValidator();
        System.out.println("Provide index: ");
        Scanner indexInput = new Scanner(System.in);

        PositionResult positionResult = inputValidator.checkPosition(indexInput.nextLine());
        while (!positionResult.isValid()) {
            System.out.println("Provided index is incorrect. Index has to be a number");
            positionResult = inputValidator.checkPosition(indexInput.nextLine());
        }

        return positionResult.getParsedResult();
    }
}
