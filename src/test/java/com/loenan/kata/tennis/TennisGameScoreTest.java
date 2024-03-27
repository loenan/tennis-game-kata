package com.loenan.kata.tennis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TennisGameScoreTest {

    private TennisGameScore tennisGameScore = new TennisGameScore();

    @ParameterizedTest
    @MethodSource("provideScoreArguments")
    void shouldReturnExpectedMessages_givenBallWinners(String gameBallWinners, List<String> expectedMessages) {
        List<String> scoreMessages = tennisGameScore.getScoreMessages(gameBallWinners);

        assertThat(scoreMessages).containsExactlyElementsOf(expectedMessages);
    }

    public static Stream<Arguments> provideScoreArguments() {
        return Stream.of(
            arguments("A", List.of("Player A : 15 / Player B : 0")),
            arguments("B", List.of("Player A : 0 / Player B : 15")),
            arguments("", emptyList()),
            arguments(null, emptyList()),
            arguments("AB", List.of(
                "Player A : 15 / Player B : 0",
                "Player A : 15 / Player B : 15"
            )),
            arguments("AA", List.of(
                "Player A : 15 / Player B : 0",
                "Player A : 30 / Player B : 0"
            )),
            arguments("AAA", List.of(
                "Player A : 15 / Player B : 0",
                "Player A : 30 / Player B : 0",
                "Player A : 40 / Player B : 0"
            )),
            arguments("BB", List.of(
                "Player A : 0 / Player B : 15",
                "Player A : 0 / Player B : 30"
            )),
            arguments("BBB", List.of(
                "Player A : 0 / Player B : 15",
                "Player A : 0 / Player B : 30",
                "Player A : 0 / Player B : 40"
            )),
            arguments("ABABA", List.of(
                "Player A : 15 / Player B : 0",
                "Player A : 15 / Player B : 15",
                "Player A : 30 / Player B : 15",
                "Player A : 30 / Player B : 30",
                "Player A : 40 / Player B : 30"
            )),
            arguments("ABABAB", List.of(
                "Player A : 15 / Player B : 0",
                "Player A : 15 / Player B : 15",
                "Player A : 30 / Player B : 15",
                "Player A : 30 / Player B : 30",
                "Player A : 40 / Player B : 30",
                "Deuce"
            ))
        );
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
