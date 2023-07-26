package com.tlglearning.practice;

import java.util.*;

public class Combinations {
    /*
    Overview: when given an array, find all distinct triples that come to a sum of 0, otherwise known as negation which is finding the opposites of value.
     Each distinct triplet (three values) from the array referenced by the data parameter, where the three values sum to zero, must be packaged into a Set<Integer> and included as an element of the Set<Set<Integer>> returned by the zeroSumTriples(int[]) method.
     The Set<Set<Integer>> returned by the zeroSumTriples(int[]) must not contain any null elements or Set<Integer> elements that do not sum to zero.
     You may assume that all values in data are distinct. Beyond that, you should make no assumptions regarding specific values in the array, the order of values in the array, or the length of the array.
     There is no requirement with regard to the mutability or specific implementation class of the Set returned (nor to that of the Set<Integer> instances contained within the outer Set); it is only required that your method return the result as a Set<Set<Integer>>.
     */
    public static Set<? extends Set<Integer>> zeroSumTriples(int[] data) {
        // Step 1: Create a Set to store the resulting triplets.
        Set<Set<Integer>> result = new HashSet<>();

        // Step 2: Get the length of the input array.
        int n = data.length;

        // Step 3: Sort the input array to make it easier to find unique triplets.
        Arrays.sort(data);

        // Step 4: Traverse the array with three nested loops to find all possible triplets.
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            int targetSum = -data[i]; // The target sum for each triplet is the negation of the current element.

            // Step 5: Use two pointers (left and right) to find the other two elements of the triplet.
            while (left < right) {
                int sum = data[left] + data[right]; // Calculate the sum of the two elements.

                // Step 6: If the sum matches the target sum, we have found a triplet.
                if (sum == targetSum) {
                    // Step 7: Add the triplet as an immutable set to the result set.
                    result.add(Set.of(data[i], data[left], data[right]));

                    // Step 8: Move the pointers towards the middle to find other triplets.
                    left++;
                    right--;
                }
                // Step 9: If the sum is less than the target sum, move the left pointer to increase the sum.
                else if (sum < targetSum) {
                    left++;
                }
                // Step 10: If the sum is greater than the target sum, move the right pointer to decrease the sum.
                else {
                    right--;
                }
            }
        }

        // Step 11: Return the set of triplets that sum to zero.
        return result;
    }
}
