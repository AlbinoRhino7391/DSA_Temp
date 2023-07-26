package com.algorithms;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class SearchAlgorithm {

    public static int linearSearch(int needle, int[] haystack) {
        // Loop through each element of the array
        for (int i = 0; i < haystack.length; i++) {
            // Compare the current element with the needle
            if (haystack[i] == needle) {
                // If found, return the index where the needle is located
                return i;
            }
        }
        // If the needle is not found, return -1
        return -1;
    }

    public static int binarySearch(int needle, int[] haystack) {
        if (haystack == null){
            return -1;
        }
        // Initialize two pointers: low and high, representing the boundaries of the search space.
        int low = 0;
        int high = haystack.length - 1;

        // Initialize a variable to count the number of iterations in the binary search.
        int iterations = 0;

        while (low <= high) {
            // Calculate the mid index as the average of low and high, avoiding potential integer overflow.
            int mid = low + (high - low) / 2;

            // Check if the middle element is the needle.
            if (haystack[mid] == needle) {
                // Print the number of iterations and return the index where the needle is located.
                System.out.println("Number of iterations: " + iterations);
                return mid;
            }

            // If the needle is smaller than the middle element, ignore the high half of the search space.
            if (haystack[mid] > needle) {
                high = mid - 1;
            } else {
                // If the needle is larger, ignore the low half of the search space.
                low = mid + 1;
            }

            // Increment the iteration count for each iteration in the binary search.
            iterations++;
        }

        // If the needle is not found, print the number of iterations and return -1.
        System.out.println("Number of iterations: " + iterations);
        return -1;
    }

    private static int binarySearch(int needle, int[] haystack, int low, int high) {
        // Base case: if the low index is greater than the high index, the needle is not found.
        if (low > high) {
            return -1;
        }

        // Calculate the mid index as the average of low and high, avoiding potential integer overflow.
        int mid = low + (high - low) / 2;

        // Check if the middle element is the needle.
        if (haystack[mid] == needle) {
            return mid;
        } else if (haystack[mid] > needle) {
            // If the needle is smaller, search in the left half of the array recursively.
            return binarySearch(needle, haystack, low, mid - 1);
        } else {
            // If the needle is larger, search in the right half of the array recursively.
            return binarySearch(needle, haystack, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{3,7,1,5,13,11,15};
        int[] sorted = new int[]{1,3,5,7,11,13,15};
        // TODO-Lab2.1.A: Invoke linearSearch(int, int[]) method (and print the result) twice: once
        //  with a value actually present in the array, and once with a value not in the array.
        System.out.println(SearchAlgorithm.linearSearch(7,unsorted));
        System.out.println(SearchAlgorithm.linearSearch(2,unsorted));
        // TODO-Lab2.1.B: Invoke binarySearch(int, int[]) method (and print the result) twice: once
        //  with a value actually present in the array, and once with a value not in the array.
        System.out.println(SearchAlgorithm.binarySearch(7,sorted));
        System.out.println(SearchAlgorithm.binarySearch(2,sorted));

        //Lab2.1.C
        System.out.println(SearchAlgorithm.binarySearch(7,sorted,0,sorted.length-1));
        System.out.println(SearchAlgorithm.binarySearch(2,sorted,0,sorted.length-1));
    }

}