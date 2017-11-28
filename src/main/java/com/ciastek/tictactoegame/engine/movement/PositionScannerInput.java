package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.ui.*;

import java.util.ResourceBundle;

public class PositionScannerInput implements PositionInput {

    private final InputReader inputReader;
    private final ResourceBundle resourceBundle;
    private final Printer printer;

    public PositionScannerInput(InputReader inputReader, ResourceBundle resourceBundle, Printer printer) {
        this.printer = printer;
        this.inputReader = inputReader;
        this.resourceBundle = resourceBundle;
    }

    public Position getPosition(Player player){
        printer.notify(new PlayerTurnEvent(resourceBundle, player.getCharacter()));

        InputValidator inputValidator = new InputValidator();
        printer.notify(new ProvidePositionEvent(resourceBundle));

        PositionResult positionResult = inputValidator.checkPosition(inputReader.readInput());
        while (!positionResult.isValid()) {
            if(positionResult.isQuit()) {
                break;
            }

            printer.notify(new IncorrectIndexFormatEvent(resourceBundle));
            positionResult = inputValidator.checkPosition(inputReader.readInput());
        }

        return positionResult.getParsedResult();
    }
}
