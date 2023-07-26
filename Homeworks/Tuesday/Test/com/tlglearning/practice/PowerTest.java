package com.tlglearning.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PowerTest {
    @Test
    public void testIsPowerOfFour1() {
        long input = 1;
        assertEquals(true, Power.isPowerOfFour(input));
    }

    @Test
    public void testIsPowerOfFour2() {
        long input = 4_294_967_296L;
        assertEquals(true, Power.isPowerOfFour(input));
    }

    @Test
    public void testIsNotPowerOfFour1() {
        long input = 65;
        assertEquals(false, Power.isPowerOfFour(input));
    }

    @Test
    public void testIsNotPowerOfFour2() {
        long input = 8_589_934_592L;
        assertEquals(false, Power.isPowerOfFour(input));
    }

    @Test
    public void testIsPowerOfFour_Exception1() {
        long input = 0;
        assertThrows(IllegalArgumentException.class, () -> Power.isPowerOfFour(input));
    }

    @Test
    public void testIsPowerOfFour_Exception2() {
        long input = -16;
        assertThrows(IllegalArgumentException.class, () -> Power.isPowerOfFour(input));
    }
}
