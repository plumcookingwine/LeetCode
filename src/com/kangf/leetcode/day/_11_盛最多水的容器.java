package com.kangf.leetcode.day;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * <p>
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 */
public class _11_盛最多水的容器 {

    public static void main(String[] args) {

        System.out.println("max === " + new Solution().maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    private static class Solution {

        /**
         * 头尾指针
         *
         * 执行用时： 4 ms , 在所有 Java 提交中击败了 66.76% 的用户
         * 内存消耗： 40 MB  , 在所有 Java 提交中击败了 39.42% 的用户
         */
        public int maxArea2(int[] height) {

            int i = 0;
            int j = height.length - 1;

            int len = height.length;

            int sum = 0;

            while (i < j) {
                int left = height[i];
                int right = height[j];
                sum = Math.max(sum, Math.min(left, right) * (--len));

                if (left < right) {
                    i++;
                } else {
                    j--;
                }

            }


            return sum;
        }

        /**
         * 暴力法
         * <p>
         * 执行用时： 770 ms , 在所有 Java 提交中击败了 21.26% 的用户
         * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 92.87% 的用户
         */
        public int maxArea(int[] height) {

            if (height.length < 2) return 0;

            int sum = 0;

            for (int i = 0; i < height.length; i++) {

                int target = height[i];

                for (int j = i + 1; j < height.length; j++) {

                    int news = height[j];

                    // 取最小的数
                    int finals = Math.min(target, news);

                    // 最小的数 * 间隔，就是容量，取最大
                    sum = Math.max(sum, finals * (j - i));

                }


            }

            return sum;

        }
    }

}
