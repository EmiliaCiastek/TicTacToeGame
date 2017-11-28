package com.ciastek.tictactoegame.ui;

public interface Result<T> {
    boolean isValid();
    T getParsedResult();
}
