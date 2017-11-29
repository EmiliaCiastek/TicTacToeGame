package com.ciastek.tictactoegame.ui;

public interface Result<T> {
    ResultState getResultState();

    T getParsedResult();
}