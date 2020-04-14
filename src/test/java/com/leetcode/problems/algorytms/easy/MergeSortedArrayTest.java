package com.leetcode.problems.algorytms.easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortedArrayTest {
    private MergeSortedArray mergeSortedArray = new MergeSortedArray();

    private void testMerge(int[] fst, int fstLen, int[] snd, int[] expected) {
        mergeSortedArray.merge(fst, fstLen, snd, snd.length);
        assertArrayEquals(expected, fst);
    }

    @Test
    public void addOnTheEnd() throws Exception {
        testMerge(
                new int[]{1, 2, 3, 0, 0, 0},
                3,
                new int[]{4, 5, 6},
                new int[]{1, 2, 3, 4, 5, 6});

    }

    @Test
    public void addOnStart() throws Exception {
        testMerge(
                new int[]{4, 5, 0, 0, 0},
                2,
                new int[]{1, 2, 3},
                new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void mixin() throws Exception {
        testMerge(
                new int[]{1, 3, 5, 0, 0, 0},
                3,
                new int[]{2, 4, 6},
                new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    public void withDuplicates() throws Exception {
        testMerge(
                new int[]{1, 3, 6, 0, 0, 0, 0, 0},
                3,
                new int[]{2, 3, 4, 5, 6},
                new int[]{1, 2, 3, 3, 4, 5, 6, 6});
    }

    @Test
    public void extremes() throws Exception {
        testMerge(new int[]{0}, 0, new int[]{1}, new int[]{1});
        testMerge(new int[]{1}, 1, new int[0], new int[]{1});
        testMerge(new int[0], 0, new int[0], new int[0]);
    }
}