package com.github.vvv1559.algorithms.leetcode.other;

import com.github.vvv1559.algorithms.annotations.Difficulty;
import com.github.vvv1559.algorithms.annotations.Level;

import java.util.ArrayList;
import java.util.List;


/*
 * Original text: https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 * */

@Difficulty(Level.EASY)
class PascalsTriangle2 {

    List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex);

        if (rowIndex < 0) {
            return row;
        }

        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }
}
