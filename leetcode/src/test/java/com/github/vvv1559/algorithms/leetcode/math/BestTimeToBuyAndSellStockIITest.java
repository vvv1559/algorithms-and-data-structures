package com.github.vvv1559.algorithms.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockIITest {

    @Test
    public void maxProfit() {
        BestTimeToBuyAndSellStockII buyAndSellStock = new BestTimeToBuyAndSellStockII();
        assertEquals(7, buyAndSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, buyAndSellStock.maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, buyAndSellStock.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}