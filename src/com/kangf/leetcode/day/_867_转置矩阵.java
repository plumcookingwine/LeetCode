package com.kangf.leetcode.day;

/**
 * 867. 转置矩阵
 * 难度
 * 简单
 * <p>
 * 170
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * 2      4    -1
 * -10    5    11
 * 18     -7    6
 * <p>
 * ||
 * <p>
 * <p>
 * 2   -10   18
 * 4    5    -7
 * -1   11   6
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 */
public class _867_转置矩阵 {

    public static void main(String[] args) {

        int[][] a = new int[][]{
                {2, 4, -1},
                {-10, 5, 11},
                {18, -7, 6}
        };

        int[][] trans = new Solution().transpose(a);
        for (int[] tran : trans) {
            for (int i : tran) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    private static class Solution {
        public int[][] transpose(int[][] matrix) {
            int r = matrix.length;
            int c = matrix[0].length;

            int[][] news = new int[c][r];
            int[] ans = new int[r];

            for (int j = 0; j < c; j++) {
                for (int i = 0; i < r; i++) {
                    ans[i] = matrix[i][j];
                }
                news[j] = ans;
            }
            return news;
        }
    }
}
