package com.ciastek.tictactoegame.ui;

import com.ciastek.tictactoegame.engine.events.IncorrectIndexFormatEvent;
import com.ciastek.tictactoegame.engine.events.PlayerTurnEvent;
import com.ciastek.tictactoegame.engine.events.ProvidePositionEvent;
import com.ciastek.tictactoegame.engine.movement.Position;
import com.ciastek.tictactoegame.engine.player.Player;

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

    public Position getPosition(Player player) {
        printer.notify(new PlayerTurnEvent(resourceBundle, player.getCharacter()));

        InputValidator inputValidator = new InputValidator();
        printer.notify(new ProvidePositionEvent(resourceBundle));
        String inputLine = inputReader.readInput();

        PositionResult positionResult = inputValidator.checkPosition(inputLine);
        while (!positionResult.isValid()) {
            printer.notify(new IncorrectIndexFormatEvent(resourceBundle));
            inputLine = inputReader.readInput();
            positionResult = inputValidator.checkPosition(inputLine);
        }

        return positionResult.getParsedResult();
    }

}
