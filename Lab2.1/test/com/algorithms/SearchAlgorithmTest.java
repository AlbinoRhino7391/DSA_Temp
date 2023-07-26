package com.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SearchAlgorithmTest {

    // TODO-Lab2.1/2.2: Implement tests
   int array[];

    @Before
    public void setUp() {
        array = new int[]{1, 4, 6, 8, 9, 10, 12, 13, 23, 44};
    }
    private static final int[] haystack = {2,4,6,8,10,12,14,16};
    @Test
    public void linearSearch_Found(){
        assertEquals(3, SearchAlgorithm.linearSearch(8,haystack));
    }

    @Test
    public void binarySearchTarget() {

        int target = 6;

        int expected = 2;

        int actual = SearchAlgorithm.binarySearch(target, array);

        assertEquals(expected, actual);

    }

    @Test
    public void binarySearchNotFound() {
        int target = 7;

        int expected = -1;

        int actual = SearchAlgorithm.binarySearch(target, array);

        assertEquals(expected, actual);

    }

    @Test
    public void binarySearchNullArray() {
        int nullArray[] = null;

        int expected = -1;
        assertEquals(expected, SearchAlgorithm.binarySearch(6, nullArray));

    }


}