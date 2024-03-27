package com.loenan.kata.tennis;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void shouldReturn0vs15Message_whenPlayerBWinFirstBall() {
        // given
        String gameBallWinners = "B";

        // when
        List<String> scoreMessages = tennisGameScore.getScoreMessages(gameBallWinners);

        // then
        assertThat(scoreMessages).containsExactly("Player A : 0 / Player B : 15");
    }

    @Test
    void shouldReturnNoMessage_whenNoBallPlayed() {
        // given
        String gameBallWinners = "";

        // when
        List<String> scoreMessages = tennisGameScore.getScoreMessages(gameBallWinners);

        // then
        assertThat(scoreMessages).isEmpty();
    }

    @Test
    void shouldReturnNoMessage_whenNullPassed() {
        // given
        String gameBallWinners = null;

        // when
        List<String> scoreMessages = tennisGameScore.getScoreMessages(gameBallWinners);

        // then
        assertThat(scoreMessages).isEmpty();
    }

    @Test
    void shouldThrow_whenInvalidPlayerPassed() {
        // given
        String gameBallWinners = "C";

        // when
        assertThatThrownBy(() -> tennisGameScore.getScoreMessages(gameBallWinners))
            // then
            .isInstanceOf(IllegalArgumentException.class);
    }
}
