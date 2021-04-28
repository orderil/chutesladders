package com.candidate.chutesladders.model;

import com.candidate.chutesladders.utils.Spinner;

import java.util.*;

/**
 * Determines the player who goes first.
 * ATTN: See its corresponding {@link com.candidate.chutesladders.model.FirstPlayerTest unit test}.
 */
class FirstPlayer {
    private final List<Player> players;

    FirstPlayer(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    /**
     * Determine the index of the player to go first.
     *
     * @return the player index in the list.
     */
    int determine() {
        int currentHighest;
        long highestCount;
        // player index --> spinnerValue
        Map<Integer, Integer> map;
        do {
            map = new HashMap<>();
            currentHighest = 0;
            for (int i = 0; i < this.players.size(); i++) {
                int spinnerValue = Spinner.spin();
                if (spinnerValue > currentHighest) {
                    currentHighest = spinnerValue;
                }
                map.put(i, spinnerValue);
            }
            final int highest = currentHighest;
            highestCount = map.values().stream().filter(value -> value == highest).count();

            /* todo: remove this debugging stuff
            if (highestCount > 1) {
                System.out.println("\thighestCount=" + highestCount);
            }
            */

        } while (highestCount > 1);

        final int highestSpinnerValue = currentHighest;
        int playerIndex = map.entrySet().stream().filter(entry -> entry.getValue().equals(highestSpinnerValue)).findFirst().get().getKey();

        /* todo: remove this debugging stuff
        System.out.println("highestCount=" + highestCount);
        System.out.println("highestSpinnerValue=" + highestSpinnerValue);
        System.out.println("playerIndex=" + playerIndex);
        */

        return playerIndex;
    }

}
