package com.candidate.chutesladders.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SpinnerTest {
    private static final int TEST_RUN_COUNT = 100;

    @DisplayName("Make sure the Spinner returns values from 1 to 6")
    @Test
    void testSpinner() {
        for (int i = 0; i < TEST_RUN_COUNT; i++) {
            int randomValue = Spinner.spin();
            assertTrue(randomValue >= 1 && randomValue <= 6);
        }
    }

}
