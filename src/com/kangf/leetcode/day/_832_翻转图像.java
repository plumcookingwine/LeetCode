package com.kangf.leetcode.day;

/**
 * 832. 翻转图像
 * 难度
 * 简单
 * <p>
 * 227
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2：
 * <p>
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class _832_翻转图像 {

    public static void main(String[] args) {

//        System.out.println(0^1);
//        System.out.println(1^1);

        int[][] a = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        int[][] reverse = new Solution().flipAndInvertImage(a);

        for (int[] ints : reverse) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

    }


    private static class Solution {
        // 进行交换,并异或运算
        public int[][] flipAndInvertImage(int[][] A) {
            for (int[] ints : A) {
                int start = 0;
                int end = ints.length - 1;
                while (start <= end) {
                    int tmp = ints[start];
                    ints[start] = ints[end] ^ 1;
                    ints[end] = tmp ^ 1;
                    start++;
                    end--;
                }
            }
            return A;
        }

        // 不需要进行交换，
        // 如果所有两边不同，就不需要管了，
        // 如果左右两边相同进行异或运算
        public int[][] flipAndInvertImage2(int[][] A) {
            for (int[] ints : A) {
                int start = 0;
                int end = ints.length - 1;
                while (start <= end) {
                    if (ints[start] == ints[end]) {
                        ints[start] = ints[start] ^ 1;
                        ints[end] = ints[start];
                    }
                    start++;
                    end--;
                }
            }
            return A;
        }
    }
}


