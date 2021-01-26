package com.kangf.leetcode.day;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class _118_杨辉三角 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().generate(100).toArray()));
    }

    /**
     * 没想到跟官方题解一模一样，大意了，没有闪
     */
    private static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> rows = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> column = new ArrayList<>();
                for (int j = 0; j < i + 1; j++) {
                    // 每一行的第一个数和最后一个数都是1
                    if (j == 0 || j == i) {
                        column.add(1);
                    } else {
                        // 上一行的前一个数 + 上一行的后一个数
                        column.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
                    }
                }
                rows.add(column);
            }
            return rows;
        }
    }
}
