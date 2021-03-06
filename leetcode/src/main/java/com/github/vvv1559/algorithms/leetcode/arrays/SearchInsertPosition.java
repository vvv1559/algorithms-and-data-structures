package com.github.vvv1559.algorithms.leetcode.arrays;


/*
 * Original text: https://leetcode.com/problems/search-insert-position/#/description
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where
 * it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * */

import com.github.vvv1559.algorithms.annotations.Difficulty;
import com.github.vvv1559.algorithms.annotations.Level;

@Difficulty(Level.EASY)
class SearchInsertPosition {

    int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = nums[mid];
            if (midValue == target) return mid;

            if (midValue > target) end = --mid;
            else start = ++mid;
        }
        return start;
    }
}
