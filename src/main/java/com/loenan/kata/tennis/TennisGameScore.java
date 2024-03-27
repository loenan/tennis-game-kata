package com.loenan.kata.tennis;

import java.util.List;

public class TennisGameScore {

    /**
     * Build the score messages to display for each ball in a game.
     *
     * @param gameBallWinners a string containing the sequence of each ball winner ('A' or 'B').
     *                        Each character is 'A' or 'B', specifying which player won a ball
     * @return the list of score message to display, one for each ball
     */
    public List<String> getScoreMessages(String gameBallWinners) {
        return List.of("Player A : 15 / Player B : 0");
    }
}
