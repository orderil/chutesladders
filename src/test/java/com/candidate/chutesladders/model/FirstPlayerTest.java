package com.candidate.chutesladders.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FirstPlayerTest {
    private static final int TEST_RUN_COUNT = 100;

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                arguments(2),
                arguments(3),
                arguments(4)
        );
    }

    @DisplayName("Determine the index of the first player in the list")
    @ParameterizedTest
    @MethodSource("paramProvider")
    public void test(int playersCount) {
        final List<Player> players = new ArrayList<>();
        for (int i = 0; i < playersCount; i++) {
            players.add(new Player("Player " + i, 0));
        }

        for (int i = 0; i < TEST_RUN_COUNT; i++) {
            int firstPlayerIndex = new FirstPlayer(players).determine();
            assertTrue(firstPlayerIndex >= 0 && firstPlayerIndex <= playersCount);
        }
    }

}