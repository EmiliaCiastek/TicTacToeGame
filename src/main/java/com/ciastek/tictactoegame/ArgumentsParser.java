package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.ui.ConsolePrinter;
import com.ciastek.tictactoegame.ui.ErrorPrinter;
import com.ciastek.tictactoegame.ui.FilePrinter;
import com.ciastek.tictactoegame.ui.Printer;

class ArgumentsParser {
    public Printer parse(String[] arguments) {
        if (arguments.length > 0) {
            switch (arguments[0]) {
                case "err":
                    return new ErrorPrinter();
                case "file":
                    return new FilePrinter();
                default:
                    return new ConsolePrinter();
            }
        }
        return new ConsolePrinter();
    }
}
