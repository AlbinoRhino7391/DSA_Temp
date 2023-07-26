package com.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {

    public static void main(String args[]) {
        int[] a = {4, 7, 5, 2, 3};
        int[] b = {4, 2, 3, 9, 1};
        Intersection simpleIntersection = new Intersection();

        // Calculate intersection using the basic intersection method
        System.out.println(simpleIntersection.intersection(a, b));

        // Calculate intersection using the faster intersection method
        System.out.println(simpleIntersection.intersectionFast(a, b));
    }

    // Basic intersection method using nested loops
    public Set<Integer> intersection(int[] a, int[] b) {
        Set<Integer> result = new HashSet<>();
        for (int x : a) {
            for (int y : b) {
                // Check if an element from array 'a' is also present in array 'b'
                if (x == y) {
                    // If yes, add it to the result set
                    result.add(x);
                }
            }
        }
        return result;
    }

    // Faster intersection method using HashSet for efficient lookups
    public Set<Integer> intersectionFast(int[] a, int[] b) {
        Set<Integer> result = new HashSet<>();

        // Store the elements of the first array in a HashSet for faster lookups
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        // Check for intersection while iterating through the second array
        for (int num : b) {
            // If the current element is present in setA, it's a common element
            if (setA.contains(num)) {
                // Add it to the result set
                result.add(num);
            }
        }

        return result;
    }
}