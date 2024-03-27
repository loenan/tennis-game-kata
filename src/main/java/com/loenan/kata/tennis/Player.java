package com.loenan.kata.tennis;

public class Player {

    private static final int[] POINTS_BY_WON_BALLS = {
        0, 15, 30, 40
    };

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

    public String getSimpleScoreMessage() {
        return String.format("Player %s : %d",
            identifier,
            getScorePoints()
        );
    }

    private int getScorePoints() {
        return POINTS_BY_WON_BALLS[wonBalls];
    }
}
