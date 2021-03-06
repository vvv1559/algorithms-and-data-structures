package com.github.vvv1559.algorithms.leetcode.math;

import com.github.vvv1559.algorithms.annotations.Difficulty;
import com.github.vvv1559.algorithms.annotations.Level;

@Difficulty(Level.EASY)
class BestTimeToBuyAndSellStockII {

    int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int min = prices[0];
        int max = prices[0];
        int result = 0;

        int lastIndex = prices.length - 1;
        for (int i = 1; i < prices.length; i++) {
            int val = prices[i];

            if (val >= max) {
                max = val;
                if (i == lastIndex) result += max - min;
            } else {
                result += max - min;
                max = val;
                min = val;
            }

        }
        return result;
    }
}
