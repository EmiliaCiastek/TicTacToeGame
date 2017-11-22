package com.ciastek.tictactoegame;

public interface Result<T> {
    boolean isValid();
    T getParsedResult();
}
