package com.candidate.chutesladders.utils;

import java.util.Random;
import static com.candidate.chutesladders.utils.Constants.MAX_SPINNER_VALUE;

/**
 * The spinner to generate a random integer in the [1..6] range.
 */
public class Spinner {
    private static final Random random = new Random();

    private Spinner() {
    }

    /**
     * Return a random int number from 1 to 6.
     *
     * @return a random number.
     */
    public static int spin() {
        return random.nextInt(MAX_SPINNER_VALUE) + 1;
    }
}
