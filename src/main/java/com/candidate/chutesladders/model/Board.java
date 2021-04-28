package com.candidate.chutesladders.model;

import com.candidate.chutesladders.utils.Spinner;

import java.util.HashMap;
import java.util.Map;

import static com.candidate.chutesladders.utils.Constants.NUMBER_OF_SQUARES;

/**
 * The board with squares fields, ladders and chutes.
 * todo: an improvement: load the coordinates of ladders and chutes from an input file.
 */
public class Board {
    private final int numberOfSquares;
    private final Map<Integer, Integer> ladders;
    private final Map<Integer, Integer> chutes;
    private int movesCounter;

    private static Board instance;

    private final static Map<Integer, Integer> mapOfLadders = new HashMap<Integer, Integer>() {
        {
            put(1, 38);
            put(4, 14);
            put(9, 31);
            put(21, 42);
            put(28, 84);
            put(36, 44);
            put(51, 67);
            put(71, 91);
            put(80, 100);
        }
    };

    private final static Map<Integer, Integer> mapOfChutes = new HashMap<Integer, Integer>() {
        {
            put(98, 78);
            put(95, 75);
            put(93, 73);
            put(87, 24);
            put(64, 60);
            put(62, 19);
            put(56, 53);
            put(49, 11);
            put(47, 26);
            put(16, 6);
        }
    };

    /**
     * Get a singleton instance of the Board.
     *
     * @return an instance of Board
     */
    public static Board getInstance() {
        if (instance == null) {
            instance = new Board(NUMBER_OF_SQUARES, mapOfLadders, mapOfChutes);
        }
        return instance;
    }

    private Board(
            int numberOfSquares,
            Map<Integer, Integer> ladders,
            Map<Integer, Integer> chutes
    ) {
        this.numberOfSquares = numberOfSquares;
        this.ladders = ladders;
        this.chutes = chutes;
    }

    /**
     * Make a move for a given player.
     * @param player the player to move.
     */
    public void movePlayer(Player player) {
        final int oldLocation = player.getLocation();
        int newLocation = oldLocation + Spinner.spin();
        if (!isValidLocation(newLocation)) {
            // System.out.println("do not move");
            return;
        }

        movesCounter++;

        StringBuilder sb = new StringBuilder();
        sb.append(movesCounter)
                .append(": ")
                .append(player.getName())
                .append(": ")
                .append(oldLocation)
                .append(" --> ")
                .append(newLocation);
        if (chuteExists(newLocation)) {
            newLocation = goDown(newLocation);
            sb.append(" --CHUTE--> ")
                    .append(newLocation);
        } else if (ladderExists(newLocation)) {
            newLocation = goUp(newLocation);
            sb.append(" --LADDER--> ")
                    .append(newLocation);
        }
        System.out.println(sb);

        player.setLocation(newLocation);
    }

    public boolean isLastLocation(int location) {
        return this.numberOfSquares == location;
    }

    private boolean isValidLocation(int location) {
        return location <= this.numberOfSquares;
    }

    private boolean chuteExists(int location) {
        return chutes.containsKey(location);
    }

    private boolean ladderExists(int location) {
        return ladders.containsKey(location);
    }

    private int goDown(int location) {
        return chutes.get(location);
    }

    private int goUp(int location) {
        return ladders.get(location);
    }

}
