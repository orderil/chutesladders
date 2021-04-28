package com.candidate.chutesladders.model;

import com.candidate.chutesladders.utils.Spinner;

/**
 * A player of the game.
 */
public class Player {
    private final String name;
    /**
     * The index of the square where the player currently is.
     */
    private int location;
    /* todo: Add the age property if needed. Omitting now for simplicity sake.
    private int age;
    */

    public Player(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    /**
     * Make a move.
     */
    public void move(Board board) {
        board.movePlayer(this);
    }

    public boolean won(Board board) {
        if (board.isLastLocation(this.location)) {
            System.out.println(String.format("The winner is %s !", name));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }

}
