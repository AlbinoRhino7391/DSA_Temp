package com.algorithms;

public class MergeSort {

    public static void main(String[] arg) {
        MergeSort sorter = new MergeSort();
        int[] array = new int[]{4, 5, 33, 17, 3, 21, 1, 16};
        System.out.println("Unsorted:");
        for (int a : array) {
            System.out.println(a);
        }
        sorter.mergeSort(array, 0, array.length-1);
        System.out.println("Sorted:");
        for (int a : array) {
            System.out.println(a);
        }
    }

    public void mergeSort(int[] array) {
        if (array != null) {
            mergeSort(array, 0, array.length);
        }
    }

    private void mergeSort(int[] array, int start, int end) {
        // If sort range is not empty:
        if (start < end) {
            // Find the middle position.
            int middle = (start + end) / 2;

            // Sort (recursively) the left side (start to middle).
            mergeSort(array, start, middle);

            // Sort (recursively) the right side (middle+1 to end).
            mergeSort(array, middle + 1, end);

            // Merge left and right sides.
            merge(array, start, middle, end);
        }
    }


    private void merge(int[] array, int left, int right, int end) {
        // 1. Create a destination array.
        int[] destination = new int[end - left + 1];

        // 2. Starting from the lowest position in both left and right sides, and continuing until
        // one of the two sides is exhausted.
        int leftIndex = left;
        int rightIndex = right + 1;
        int destinationIndex = 0;

        while (leftIndex <= right && rightIndex <= end) {
            // If value on left is less than or equal to value on right:
            if (array[leftIndex] <= array[rightIndex]) {
                // Copy value from left to destination array.
                destination[destinationIndex] = array[leftIndex];
                // Advance to the next position on the left.
                leftIndex++;
            } else {
                // Copy value from right to destination array.
                destination[destinationIndex] = array[rightIndex];
                // Advance to the next position on the right.
                rightIndex++;
            }
            // Advance to the next position in the destination array.
            destinationIndex++;
        }

        // 3. Copy any remaining values from the side that is not yet exhausted to the destination.
        while (leftIndex <= right) {
            destination[destinationIndex] = array[leftIndex];
            leftIndex++;
            destinationIndex++;
        }

        while (rightIndex <= end) {
            destination[destinationIndex] = array[rightIndex];
            rightIndex++;
            destinationIndex++;
        }

        // 4. Copy values back from destination to the original array.
        for (int i = left; i <= end; i++) {
            array[i] = destination[i - left];
        }
    }
}

