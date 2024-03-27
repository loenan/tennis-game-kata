package com.loenan.kata.tennis;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class Game {

    private static final Comparator<Player> PLAYER_COMPARATOR =
        Comparator.comparing(Player::getWonBalls)
            .thenComparing(Player::getIdentifier);  // to make sure to distinguish the players if won balls are equal

    private final List<Player> players;

    public Game(char player1Identifier, char player2Identifier) {
        players = List.of(new Player(player1Identifier), new Player(player2Identifier));
    }

    public void ballWon(char ballWinnerIdentifier) {
        Player ballWinner = players.stream()
            .filter(player -> Objects.equals(player.getIdentifier(), ballWinnerIdentifier))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Invalid player: " + ballWinnerIdentifier));
        ballWinner.incrementWonBalls();
    }

    public String getCurrentScoreMessage() {
        if (isScore40ReachedByBothPlayers()) {
            Player leadingPlayer = players.stream().max(PLAYER_COMPARATOR)
                .orElseThrow();  // should never throw, the stream is never empty
            Player ledPlayer = players.stream().min(PLAYER_COMPARATOR)
                .orElseThrow();  // should never throw, the stream is never empty

            int wonBallDifference = leadingPlayer.getWonBalls() - ledPlayer.getWonBalls();
            return switch (wonBallDifference) {
                case 0 -> "Deuce";
                case 1 -> leadingPlayer.getAdvantageMessage();
                default -> leadingPlayer.getWinGameMessage();
            };
        }

        // case where a player win the game, but the other player didn't reach score 40
        Optional<Player> winnerPlayer = players.stream()
            .filter(Player::isScoreToWinGameReached)
            .findFirst();
        if (winnerPlayer.isPresent()) {
            return winnerPlayer.get().getWinGameMessage();
        }

        return players.stream()
            .map(Player::getSimpleScoreMessage)
            .collect(joining(" / "));
    }

    private boolean isScore40ReachedByBothPlayers() {
        return players.stream().allMatch(Player::isScore40Reached);
    }
}
