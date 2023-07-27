package com.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Set;
import java.util.function.BiFunction;
import org.junit.Before;
import org.junit.Test;

public class IntersectionTest {

    private Intersection intersection;

    @Before
    public void setUp() {
        intersection = new Intersection();
    }

    @Test
    public void intersection_nonEmpty() {
        int[] numbers1 = new int[]{66, 24, 75, 22, 12, 87};
        int[] numbers2 = new int[]{32, 41, 98, 66, 39, 24};
        Set<Integer> expected = Set.of(24, 66);
        testForSymmetricSuccess(numbers1, numbers2, expected, intersection::intersection);
    }

    @Test
    public void intersectionFast_nonEmpty() {
        int[] numbers1 = new int[]{66, 24, 75, 22, 12, 87};
        int[] numbers2 = new int[]{32, 41, 98, 66, 39, 24};
        Set<Integer> expected = Set.of(24, 66);
        testForSymmetricSuccess(numbers1, numbers2, expected, intersection::intersectionFast);
    }

    @Test
    public void intersection_subset() {
        int[] numbers1 = new int[]{66, 24, 75, 22, 12, 87};
        int[] numbers2 = new int[]{24, 87, 66};
        Set<Integer> expected = Set.of(24, 66, 87);
        testForSymmetricSuccess(numbers1, numbers2, expected, intersection::intersection);
    }

    @Test
    public void intersectionFast_subset() {
        int[] numbers1 = new int[]{66, 24, 75, 22, 12, 87};
        int[] numbers2 = new int[]{24, 87, 66};
        Set<Integer> expected = Set.of(24, 66, 87);
        testForSymmetricSuccess(numbers1, numbers2, expected, intersection::intersectionFast);
    }

    @Test
    public void intersection_identical() {
        int[] a = {4, 7, 5, 2, 3};
        int[] b = {4, 7, 5, 2, 3};

        Set<Integer> expected = Set.of(4, 7, 5, 2, 3);
        testForSymmetricSuccess(a, b, expected, intersection::intersection);
    }

    @Test
    public void intersectionFast_identical() {
        int[] a = {4, 7, 5, 2, 3};
        int[] b = {4, 7, 5, 2, 3};

        Set<Integer> expected = Set.of(4, 7, 5, 2, 3);
        testForSymmetricSuccess(a, b, expected, intersection::intersectionFast);
    }

    @Test
    public void intersection_empty() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        Set<Integer> expected = Set.of();
        testForSymmetricSuccess(a, b, expected, intersection::intersection);
    }

    @Test
    public void intersectionFast_empty() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        Set<Integer> expected = Set.of();
        testForSymmetricSuccess(a, b, expected, intersection::intersectionFast);
    }

    @Test(expected = NullPointerException.class)
    public void intersection_nullArg() {
        int[] a = {1, 2, 3};
        int[] b = null;

        intersection.intersection(a, b);
    }

    @Test(expected = NullPointerException.class)
    public void intersectionFast_nullArg() {
        int[] a = {1, 2, 3};
        int[] b = null;

        intersection.intersectionFast(a, b);
    }

    private void testForSymmetricSuccess(int[] a, int[] b, Set<Integer> expected,
            BiFunction<int[], int[], Set<Integer>> invocation) {
        assertEquals(expected, invocation.apply(a, b));
        assertEquals(expected, invocation.apply(b, a));
    }

}
