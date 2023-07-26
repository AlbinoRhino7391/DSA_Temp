package com.tlglearning.practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    @Test
    public void testPerfectSquares() {
        assertTrue(Square.isPerfectSquare(0));
        assertTrue(Square.isPerfectSquare(4_096L));
        assertTrue(Square.isPerfectSquare(428_135_971_041L));
    }

    @Test
    public void testNonPerfectSquares() {
        assertFalse(Square.isPerfectSquare(2));
        assertFalse(Square.isPerfectSquare(4_097L));
        assertFalse(Square.isPerfectSquare(428_135_971_042L));
    }

    @Test
    public void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> Square.isPerfectSquare(-1));
    }
}
