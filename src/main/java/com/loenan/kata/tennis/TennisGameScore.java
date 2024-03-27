package com.loenan.kata.tennis;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static java.util.Collections.emptyList;

public class TennisGameScore {

    /**
     * Build the score messages to display for each ball in a game.
     *
     * @param gameBallWinners a string containing the sequence of each ball winner ('A' or 'B').
     *                        Each character is 'A' or 'B', specifying which player won a ball
     * @return the list of score message to display, one for each ball
     */
    public List<String> getScoreMessages(String gameBallWinners) {
        if (StringUtils.isEmpty(gameBallWinners)) {
            return emptyList();
        }
        if (gameBallWinners.startsWith("A")) {
            return List.of("Player A : 15 / Player B : 0");
        } else {
            return List.of("Player A : 0 / Player B : 15");
        }
    }
}
