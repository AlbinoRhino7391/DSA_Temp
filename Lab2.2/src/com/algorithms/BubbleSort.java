package com.algorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        // The input array that needs to be sorted
        int[] input = {22, 15, 13, 9, 6, 3, 1};

        // Display the original input array
        System.out.println("Original Array: " + Arrays.toString(input));

        // Call the sort method to sort the input array
        sort(input);

        // Display the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(input));
    }

    public static void sort(int[] numbers) { //sorts a given array in ascending order
        // Get the length of the input array
        int n = numbers.length;

        // A flag to indicate whether any swaps occurred in the current pass
        boolean swapped;

        // Outer loop to iterate over the array elements
        // It runs (n-1) times, where n is the number of elements in the array
        for (int i = 0; i < n - 1; i++) {
            // Initialize the 'swapped' flag as false at the start of each pass
            swapped = false;

            // Inner loop to compare adjacent elements and swap if necessary
            // It runs from the first element to the (n-i-1)-th element
            // Since the largest element will be "bubbled" to the end in each pass,
            // there is no need to compare the already sorted elements
            for (int j = 0; j < n - i - 1; j++) {
                // Compare the current element with its neighbor
                if (numbers[j] > numbers[j + 1]) {
                    // Swap the elements because they are in the wrong order
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;

                    // Set the 'swapped' flag to true as a swap occurred in this pass
                    swapped = true;
                }
            }

            // If no swaps occurred in the current pass, the array is already sorted
            // No need to continue further iterations, break out of the loop
            if (!swapped) {
                break;
            }
        }
    }
}

