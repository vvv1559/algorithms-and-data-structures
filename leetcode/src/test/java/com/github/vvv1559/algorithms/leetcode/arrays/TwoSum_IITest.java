package com.github.vvv1559.algorithms.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSum_IITest {

    @Test
    public void twoSum() {
        TwoSum_II twoSum = new TwoSum_II();
        assertArrayEquals(new int[]{1, 2}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{2, 3}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 18));
        assertArrayEquals(new int[]{2, 4}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 22));
        assertArrayEquals(new int[]{3, 4}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 26));
    }
}