package com.loenan.kata.tennis;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TennisGameScoreTest {

    private TennisGameScore tennisGameScore = new TennisGameScore();

    @Test
    void shouldReturn15vs0Message_whenPlayerAWinFirstBall() {
        // given
        String gameBallWinners = "A";

        // when
        List<String> scoreMessages = tennisGameScore.getScoreMessages(gameBallWinners);

        // then
        assertThat(scoreMessages).containsExactly("Player A : 15 / Player B : 0");
    }
}
