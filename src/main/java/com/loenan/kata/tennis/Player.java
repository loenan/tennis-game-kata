package com.loenan.kata.tennis;

public class Player {

    private static final int[] POINTS_BY_WON_BALLS = {
        0, 15, 30, 40
    };

    private static final int MINIMUM_WON_BALLS_TO_REACH_SCORE_40 = 3;
    private static final int MINIMUM_WON_BALLS_TO_WIN_GAME = 4;

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

    public boolean isScore40Reached() {
        return wonBalls >= MINIMUM_WON_BALLS_TO_REACH_SCORE_40;
    }

    public boolean winAgainst(Player otherPlayer) {
        return wonBalls >= MINIMUM_WON_BALLS_TO_WIN_GAME
            && wonBalls >= otherPlayer.wonBalls + 2;
    }

    public String getSimpleScoreMessage() {
        return String.format("Player %s : %d",
            identifier,
            getScorePoints()
        );
    }

    public String getWinGameMessage() {
        return String.format("Player %s wins the game", identifier);
    }

    private int getScorePoints() {
        return POINTS_BY_WON_BALLS[wonBalls];
    }
}
