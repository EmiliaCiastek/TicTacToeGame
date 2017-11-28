package com.ciastek.tictactoegame;

import com.ciastek.tictactoegame.ui.ConsolePrinter;
import com.ciastek.tictactoegame.ui.ErrorPrinter;
import com.ciastek.tictactoegame.ui.FilePrinter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArgumentsParserTest {

    @Test
    public void givenEmptyArgumentsWhenParseThenReturnConsolePrinter(){
        ArgumentsParser argParser = new ArgumentsParser();
        Class<ConsolePrinter> expectedPrinterType = ConsolePrinter.class;

        assertEquals(argParser.parse(new String[0]).getClass(), expectedPrinterType);
    }

    @Test
    public void givenErrArgumentWhenParseThenReturnErrorPrinter(){
        ArgumentsParser argParser = new ArgumentsParser();
        Class<ErrorPrinter> expectedPrinterType = ErrorPrinter.class;

        assertEquals(argParser.parse(new String[]{"err"}).getClass(), expectedPrinterType);
    }

    @Test
    public void givenFileArgumentWhenParseThenReturnFilePrinter(){
        ArgumentsParser argParser = new ArgumentsParser();
        Class<FilePrinter> expectedPrinterType = FilePrinter.class;

        assertEquals(argParser.parse(new String[]{"file"}).getClass(), expectedPrinterType);
    }

    @DataProvider(name = "unsupported argument")
    public static Object[] unsupportedArguments(){
        return new Object[]{
          new String[]{"\n"},
          new String[]{"lalala"},
          new String[]{" "},
          new String[]{""},
          new String[]{"another string"}
        };
    }
    @Test(dataProvider = "unsupported argument")
    public void givenUnsupportedArgumentWhenParseThenReturnConsolePrinter(String[] args){
        ArgumentsParser argParser = new ArgumentsParser();
        Class<ConsolePrinter> expectedPrinterType = ConsolePrinter.class;

        assertEquals(argParser.parse(args).getClass(), expectedPrinterType);
    }
}