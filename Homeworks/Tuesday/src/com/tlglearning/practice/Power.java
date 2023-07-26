package com.tlglearning.practice;

public class Power {
    public static boolean isPowerOfFour(long input) throws IllegalArgumentException {
        // Step 1: Check if the input is non-positive, and throw an exception if it is.
        if (input <= 0) {
            throw new IllegalArgumentException("Input must be a positive number.");
        }

        // Step 2: Check if the input is a power of 4.
        // Keep dividing the input by 4 until it becomes 1 or less than 1.
        // If the input becomes 1, it is a power of 4, otherwise, it is not.
        while (input > 1) {
            if (input % 4 != 0) {
                return false;
            }
            input /= 4;
        }

        return true;
    }
}
