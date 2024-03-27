package com.loenan.kata.tennis;

import java.util.List;
import java.util.Objects;

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
        return players.stream()
            .map(Player::getSimpleScoreMessage)
            .collect(joining(" / "));
    }
}
