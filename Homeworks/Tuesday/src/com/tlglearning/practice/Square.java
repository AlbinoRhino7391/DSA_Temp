package com.tlglearning.practice;
/*
 Your implementation must not change the modifiers, return type, signature (method name and parameter number/types/order)
 Your implementation must provide this functionality:
    - #1 If input is negative, isPerfectSquare(input) must throw an instance of IllegalArgumentException;
    - #2 Otherwise, if input is a perfect square, isPerfectSquare(input) must return true;
    - #3 Otherwise, isPerfectSquare(input) must return false.
 */

public class Square {
    public static boolean isPerfectSquare(long input) throws IllegalArgumentException {
        // Step 1: Check if the input number is negative. If it is, throw an exception.
        if (input < 0) {
            throw new IllegalArgumentException("Input cannot be negative");
        }

        // Step 2: If the input is 0 or 1, it is considered a perfect square.
        if (input == 0 || input == 1) {
            return true;
        }

        // Step 3: Use integer calculations to determine if the input is a perfect square.
        long sqrt = (long) Math.sqrt(input); // Compute square root as a long.
        //Note: Instead of relying on Math.sqrt(input), compute the square root using long sqrt = (long) Math.sqrt(input);. This returns the square root as a long, and since we are dealing with long values, it avoids the issue of potential inaccuracies when converting to double.

        // Step 4: Check if the square of the calculated square root is equal to the input.
        // Note: Using Math.pow(input, 0.5) could introduce floating-point inaccuracies.
        if (sqrt * sqrt == input) {
            return true;
        }

        // If no perfect square is found, return false.
        return false;
    }
}