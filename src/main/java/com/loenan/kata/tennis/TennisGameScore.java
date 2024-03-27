package com.loenan.kata.tennis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TennisGameScore {

    private static final char PLAYER_A_IDENTIFIER = 'A';
    private static final char PLAYER_B_IDENTIFIER = 'B';

    /**
     * Build the score messages to display for each ball in a game.
     *
     * @param gameBallWinners a string containing the sequence of each ball winner ('A' or 'B').
     *                        Each character is 'A' or 'B', specifying which player won a ball
     * @return the list of score message to display, one for each ball
     */
    public List<String> getScoreMessages(String gameBallWinners) {
        Game game = new Game(PLAYER_A_IDENTIFIER, PLAYER_B_IDENTIFIER);
        List<String> scoreMessages = new ArrayList<>();
        int ballCount = Optional.ofNullable(gameBallWinners)
            .map(String::length)
            .orElse(0);
        for (int i = 0; i < ballCount; i++) {
            char ballWinnerIdentifier = gameBallWinners.charAt(i);
            game.ballWon(ballWinnerIdentifier);

            scoreMessages.add(game.getCurrentScoreMessage());
        }

        return scoreMessages;
    }
}
