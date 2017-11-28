package com.ciastek.tictactoegame.engine.movement;

import com.ciastek.tictactoegame.engine.player.Player;
import com.ciastek.tictactoegame.ui.InputReader;
import com.ciastek.tictactoegame.ui.InputValidator;
import com.ciastek.tictactoegame.ui.PositionResult;
import com.ciastek.tictactoegame.ui.Printer;

public class PositionScannerInput implements PositionInput {

    private final InputReader inputReader;
    private final String filename;
    private final Printer printer;

    public PositionScannerInput(InputReader inputReader, String filename, Printer printer) {
        this.printer = printer;
        this.inputReader = inputReader;
        this.filename = filename;
    }

    public Position getPosition(Player player){
        printer.notify(new PlayerTurnEvent(player.getCharacter(), filename));

        InputValidator inputValidator = new InputValidator();
        printer.notify(new ProvidePositionEvent(filename));

        PositionResult positionResult = inputValidator.checkPosition(inputReader.readInput());
        while (!positionResult.isValid()) {
            if(positionResult.isQuit()) {
                break;
            }

            printer.notify(new IncorrectIndexFormatEvent(filename));
            positionResult = inputValidator.checkPosition(inputReader.readInput());
        }

        return positionResult.getParsedResult();
    }
}
