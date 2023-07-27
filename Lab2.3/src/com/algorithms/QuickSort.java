package com.algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String args[]) {
        QuickSort quickSort = new QuickSort();
        //int[] numbers = new int[]{2, 5, 7, 2, 4, 2, 8, 1, 0, 9, 3, 6};
        int[] numbers = new int[]{4, 5, 33, 17, 3, 21, 1, 16};
        quickSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public void sort(int[] numbers) {
        if (numbers != null) {
            sort(numbers, 0, numbers.length - 1);
        }
    }

    private void sort(int[] numbers, int start, int end) {
        // 1. return if the start value is greater than or equal to the end
        if (start >= end) {
            return;
        }

        // 2. call the partition method, passing in numbers, start, and end,
        // and getting back the int position of the pivot
        int pivotIndex = partition(numbers, start, end);

        // 3. print the partitions, using numbers and the position of the pivot from partition( )
        System.out.println("Partition: " + Arrays.toString(numbers) + " (Pivot Index: " + pivotIndex + ")");

        // 4. call this method (recursion) on the lower partition of numbers (from start to pivot-1)
        sort(numbers, start, pivotIndex - 1);

        // 5. call this method (recursion) on the higher partition of number (from pivot+1 to end)
        sort(numbers, pivotIndex + 1, end);
    }

    private int partition(int[] numbers, int start, int end) {
        // Get the value at the pivot (at array index "end")
        int pivot = numbers[end];

        // Start a variable called "top" just below the start
        // ("top" will represent the top of the lower partition)
        int top = start - 1;

        // Iterate from start to end...each time:
        for (int i = start; i < end; i++) {
            // If the current array element is less than the pivot
            if (numbers[i] < pivot) {
                // Increment "top" by 1
                top++;

                // Swap the two numbers at the "top" position and the current array index
                int temp = numbers[top];
                numbers[top] = numbers[i];
                numbers[i] = temp;
            }
        }

        // Once the loop is over, swap the values at index "top+1" with "end" position
        // This will move the pivot at the end of the array to the "top+1" position
        int temp = numbers[top + 1];
        numbers[top + 1] = numbers[end];
        numbers[end] = temp;

        // Finally, return the top value + 1
        // This will become the position of the new pivot for the next recursion
        return top + 1;
    }


    private void swap(int[] numbers, int j, int k) {
        // Initialize a temporary int variable with the value at numbers[j]
        int temp = numbers[j];

        // Copy the value at position j with the value at position k
        numbers[j] = numbers[k];

        // Copy the value in the temporary variable into numbers[k]
        numbers[k] = temp;
    }
}
