package com.ciastek.tictactoegame;

public interface Result<T> {
    boolean isValid();
    boolean isQuit();
    T getParsedResult();
}
