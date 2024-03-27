package com.loenan.kata.tennis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TennisGameScore {

    private static final int[] POINTS_BY_WON_BALLS = {
        0, 15, 30, 40
    };

    /**
     * Build the score messages to display for each ball in a game.
     *
     * @param gameBallWinners a string containing the sequence of each ball winner ('A' or 'B').
     *                        Each character is 'A' or 'B', specifying which player won a ball
     * @return the list of score message to display, one for each ball
     */
    public List<String> getScoreMessages(String gameBallWinners) {
        int ballsWonByA = 0;
        int ballsWonByB = 0;
        List<String> scoreMessages = new ArrayList<>();
        int ballCount = Optional.ofNullable(gameBallWinners)
            .map(String::length)
            .orElse(0);
        for (int i = 0; i < ballCount; i++) {
            char ballWinner = gameBallWinners.charAt(i);
            switch (ballWinner) {
                case 'A':
                    ballsWonByA++;
                    break;
                case 'B':
                    ballsWonByB++;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid player: " + ballWinner);
            }

            String newScoreMessage = String.format("Player A : %d / Player B : %d",
                POINTS_BY_WON_BALLS[ballsWonByA],
                POINTS_BY_WON_BALLS[ballsWonByB]
            );

            scoreMessages.add(newScoreMessage);
        }

        return scoreMessages;
    }
}
