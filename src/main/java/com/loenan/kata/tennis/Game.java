package com.loenan.kata.tennis;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class Game {

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
        if (isDeuce()) {
            return "Deuce";
        }

        Optional<Player> gameWinner = getGameWinner();
        if (gameWinner.isPresent()) {
            return gameWinner.get().getWinGameMessage();
        }

        return players.stream()
            .map(Player::getSimpleScoreMessage)
            .collect(joining(" / "));
    }

    private Optional<Player> getGameWinner() {
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        if (player1.winAgainst(player2)) {
            return Optional.of(player1);
        }
        if (player2.winAgainst(player1)) {
            return Optional.of(player2);
        }
        return Optional.empty();
    }

    private boolean isDeuce() {
        return players.stream().allMatch(Player::isScore40Reached)
            && players.get(0).getWonBalls() == players.get(1).getWonBalls();
    }
}
