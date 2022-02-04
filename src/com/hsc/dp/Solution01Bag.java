package com.hsc.dp;

import java.util.Arrays;

public class Solution01Bag {
    class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public int getMaxValue(Item[] items, int bagCapacity) {
        int[][] dp = new int[items.length + 1][bagCapacity + 1];

//        for (int i = 0; i < dp.length; i ++) {
//            dp[i][0] = 0;
//        }
//        Arrays.fill(dp[0], 0);

        for (int i = 1; i < dp.length; i ++) {
            for (int j = 1; j <= bagCapacity; j ++) {
                if (items[i - 1].weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i - 1].weight] + items[i - 1].value);
                }
            }
        }
        return dp[items.length][bagCapacity];
    }

    /**
     * dp最优解，空间复杂度 O(bagCapacity)
     */
    public int getMaxValue2(Item[] items, int bagCapacity) {
        int[] dp = new int[bagCapacity + 1];
        for (int i = 1; i <= items.length; i ++) {
            for (int j = bagCapacity; j >= items[i - 1].weight; j --) {
                dp[j] = Math.max(dp[j], dp[j - items[i - 1].weight] + items[i - 1].value);
            }
        }
        return dp[bagCapacity];
    }

    /**
     * 回溯法
     */
    public int getMaxValue3(Item[] items, int bagCapacity) {
        int[] choices = new int[items.length];
        return dfs(items, bagCapacity, choices, 0, 0);
    }

    public int dfs(Item[] items, int bagCapacity, int[] choices, int height, int maxValue) {
        if (height == items.length) {
            return isMaxValue(items, bagCapacity, choices, maxValue);
        }
        choices[height] = 0;
        maxValue = Math.max(maxValue, dfs(items, bagCapacity, choices, height + 1, maxValue));
        choices[height] = 1;
        return Math.max(maxValue, dfs(items, bagCapacity, choices, height + 1, maxValue));
    }

    public int isMaxValue(Item[] items, int bagCapacity, int[] choices, int maxValue) {
        int weight = 0, value = 0;
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] == 1) {
                weight += items[i].weight;
                value += items[i].value;
            }
        }
        if (weight > bagCapacity) {
            return maxValue;
        }
        return Math.max(maxValue, value);
    }

    public static void main(String[] args) {
        Solution01Bag solution = new Solution01Bag();
        Item item1 = solution.new Item(1, 1);
        Item item2 = solution.new Item(2, 6);
        Item item3 = solution.new Item(5, 18);
        Item item4 = solution.new Item(6, 22);
        Item item5 = solution.new Item(7, 28);
        Item[] items = new Item[] {item1, item2, item3, item4, item5};
        int maxValue = solution.getMaxValue3(items, 11);
        System.out.println(maxValue);

        Item item6 = solution.new Item(2, 6);
        Item item7 = solution.new Item(2, 3);
        Item item8 = solution.new Item(6, 5);
        Item item9 = solution.new Item(5, 4);
        Item item10 = solution.new Item(4, 6);
        Item[] problems = new Item[] {item6, item7, item8, item9, item10};
        System.out.println("最大价值总和是：" + solution.getMaxValue2(problems, 10));
    }
}
