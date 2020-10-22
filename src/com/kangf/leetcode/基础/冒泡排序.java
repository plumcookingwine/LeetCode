package com.kangf.leetcode.基础;

import java.util.Arrays;

public class 冒泡排序 {


    public static void main(String[] args) {

        int[] arr = new int[]{5, 7, 2, 3, 65, 8, 9, 1};
        int[] sort = new Solution().bubbleSort(arr);

        System.out.println(Arrays.toString(sort));

    }

    private static class Solution {




        /**
         * 冒泡排序
         */
        public int[] bubbleSort(int[] a) {

            for (int i = 0; i < a.length; i++) {

                for (int j = i + 1; j < a.length; j++) {

                    if (a[i] > a[j]) {
                        int ival = a[i];
                        a[i] = a[j];
                        a[j] = ival;
                    }
                }
                System.out.println("sort[" + i + "]  ====== " + Arrays.toString(a));
            }
            return a;
        }


    }
}
