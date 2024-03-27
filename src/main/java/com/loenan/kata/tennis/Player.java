package com.loenan.kata.tennis;

public class Player {

    private final char identifier;
    private int wonBalls;

    public Player(char identifier) {
        this.identifier = identifier;
    }

    public char getIdentifier() {
        return identifier;
    }

    public int getWonBalls() {
        return wonBalls;
    }

    public void incrementWonBalls() {
        wonBalls++;
    }
}
