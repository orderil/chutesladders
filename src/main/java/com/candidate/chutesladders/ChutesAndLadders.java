package com.candidate.chutesladders;

import com.candidate.chutesladders.model.Game;
import com.candidate.chutesladders.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class of the game.
 * ATTN: Currently for simplicity sake, we just pass the players' names as app parameters.
 *
 * todo: an improvement: read players' data from an input file (especially if you need additional properties of the Player class like age).
 */
public class ChutesAndLadders {

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 4) {
            System.err.println("Please specify 2, 3 or 4 player names!");
        }

        List<Player> players = new ArrayList<>();
        for (String name : args) {
            players.add(new Player(name, 0));
        }

        new Game(players).play();
    }

}
