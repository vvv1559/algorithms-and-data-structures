package com.leetcode.problems.algorytms;

import com.Difficulty;
import com.SolutionComplexity;

import java.util.HashMap;
import java.util.Map;

import static com.Difficulty.Level.EASY;

/*
* Original text: https://leetcode.com/problems/two-sum/#/description
*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
*
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
*
* Example:
*
* Given nums = [2, 7, 11, 15], target = 9,
* Because nums[0] + nums[1] = 2 + 7 = 9,
* return [0, 1].
*
* */

@Difficulty(EASY)
class TwoSum {

    @SolutionComplexity(value = "O(n)", extraMemory = "O(n)")
    int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int value = nums[i];
            final Integer secondValuePosition = values.get(target - value);

            if (secondValuePosition != null) {
                return new int[]{secondValuePosition, i};
            } else {
                values.put(value, i);
            }

        }
        return new int[0];
    }
}
