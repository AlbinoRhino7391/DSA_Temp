package com.tlglearning.practice;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationsTest {
    @Test
    public void testZeroSumTriples1() {
        int[] data = {1, -2, 2, 5, 3, 0, -4, -1};
        Set<Set<Integer>> expected = Set.of(
                Set.of(1, 3, -4),
                Set.of(1, 0, -1),
                Set.of(-2, 2, 0),
                Set.of(-2, 3, -1),
                Set.of(5, -4, -1)
        );
        assertEquals(expected, Combinations.zeroSumTriples(data));
    }

    @Test
    public void testZeroSumTriples2() {
        int[] data = {7, 10, 2, -4, -7, 9, -6, -8, 8, 6, -10, -9, 5, 4, -2, -1, -5, 3};
        Set<Set<Integer>> expected = Set.of(
                Set.of(7, 2, -9),
                Set.of(7, -6, -1),
                Set.of(7, -10, 3),
                Set.of(7, -2, -5),
                Set.of(10, -4, -6),
                Set.of(10, -8, -2),
                Set.of(10, -9, -1),
                Set.of(2, -7, 5),
                Set.of(2, -6, 4),
                Set.of(2, -8, 6),
                Set.of(2, 8, -10),
                Set.of(2, -5, 3),
                Set.of(-4, 9, -5),
                Set.of(-4, 6, -2),
                Set.of(-4, 5, -1),
                Set.of(-7, 9, -2),
                Set.of(-7, 8, -1),
                Set.of(-7, 4, 3),
                Set.of(9, -8, -1),
                Set.of(-6, 8, -2),
                Set.of(-8, 5, 3),
                Set.of(6, -10, 4),
                Set.of(6, -9, 3),
                Set.of(6, -1, -5),
                Set.of(-9, 5, 4),
                Set.of(-2, -1, 3)
        );
        assertEquals(expected, Combinations.zeroSumTriples(data));
    }
}
