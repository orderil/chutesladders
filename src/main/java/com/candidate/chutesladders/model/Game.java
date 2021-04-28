package com.candidate.chutesladders.model;

import java.util.Collections;
import java.util.List;

/**
 * A game to play.
 */
public class Game {
    private final List<Player> players;

    public Game(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    /**
     * Play the game.
     */
    public void play() {
        if (players == null || players.size() < 2 || players.size() > 4) {
            throw new IllegalArgumentException("Please use from 2 to 4 players!");
        }

        Board board = Board.getInstance();

        int firstPlayerIndex = new FirstPlayer(players).determine();

        Player player;
        do {
            // Have players play starting with the picked first one
            player = players.get(firstPlayerIndex++ % players.size());
            player.move(board);
        } while (!player.won(board));
    }

}
