package com.kangf.leetcode.day;


/**
 * 566. 重塑矩阵
 *
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * <p>
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * <p>
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * 示例 1:
 * 输入:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * <p>
 * 示例 2:
 * 输入:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 * [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 * 注意：
 * <p>
 * 给定矩阵的宽和高范围在 [1, 100]。
 * 给定的 r 和 c 都是正数。
 */
public class _566_重塑矩阵 {

    public static void main(String[] args) {

        int[][] nums = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] newArr = new Solution().matrixReshape2(nums, 2, 3);

        for (int[] ints : newArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }

    private static class Solution {

        public int[][] matrixReshape2(int[][] nums, int r, int c) {
            int a = nums.length;
            int b = nums[0].length;
            int len = a * b;
            if (len != r * c) return nums;
            int[][] ans = new int[r][c];
            for (int i = 0; i < len; i++) {
                ans[i / c][i % c] = nums[i / b][i % b];
            }
            return ans;
        }

        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (nums.length <= 0) return nums;
            if (nums.length * nums[0].length != r * c) return nums;
            int[][] newArray = new int[r][c];
            int[] a = new int[c];
            int cInd = 0;
            int rInd = 0;
            for (int[] num : nums) {
                for (int i : num) {
                    a[cInd++] = i;
                    if (cInd >= c) {
                        newArray[rInd++] = a;
                        a = new int[c];
                        cInd = 0;
                    }
                }
            }
            return newArray;
        }
    }
}
