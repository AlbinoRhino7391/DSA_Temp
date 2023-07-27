//all tests are run with Junit 5
package com.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void testBubbleSortAscending() {
        int[] input = {22, 15, 13, 9, 6, 3, 1};
        BubbleSort.sort(input);
        int[] expected = {1, 3, 6, 9, 13, 15, 22};
        Assertions.assertArrayEquals(expected, input);
    }

    @Test
    public void testBubbleSortAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        BubbleSort.sort(input);
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, input);
    }

    @Test
    public void testBubbleSortEmptyArray() {
        int[] input = {};
        BubbleSort.sort(input);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, input);
    }
}
