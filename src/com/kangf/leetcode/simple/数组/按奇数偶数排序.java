package com.kangf.leetcode.simple.数组;

/**
 * 922. 按奇偶排序数组 II
 *
 * <p>
 * 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * <p>
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * <p>
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 按奇数偶数排序 {

    public static void main(String[] args) {
        int[] a = new int[]{648, 831, 560, 986, 192, 424, 997, 829, 897, 843};

        int[] after = new Solution().sortArrayByParityII3(a);
        for (int j : after) {
            System.out.print(j + "   ");
        }
    }


    private static class Solution {

        public int[] sortArrayByParityII3(int[] A) {

            int j = 1;

            for (int i = 0; i < A.length; i += 2) {

                if ((A[i] & 1) == 1) {
                    while ((A[j] & 1) == 1) {
                        j += 2;
                    }
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }

            return A;
        }


        /**
         * 执行用时： 4 ms  , 在所有 Java 提交中击败了 33.13% 的用户
         * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 98.85% 的用户
         *
         * @param A
         * @return
         */
        public int[] sortArrayByParityII2(int[] A) {
            int size = A.length;
            if (size <= 1) return A;
            int i = 0, j = 1;
            while (i < size && j < size) {
                int ival = A[i];
                int jval = A[j];

                // 如果i对应偶数，j对应奇数,这种是没问题的，继续下一次遍历
                if ((ival & 1) != 1 && (jval & 1) == 1) {
                    i += 2;
                    j += 2;
                    continue;
                }

                // 如果i对应奇数，j对应偶数，那么两数交换
                if ((ival & 1) == 1 && (jval & 1) != 1) {
                    swap(i, j, A);
                    i += 2;
                    j += 2;
                    continue;
                }

                // 如果i对应奇数，j也对应奇数，那么j进入下一次遍历，i不变，继续对比
                if ((ival & 1) == 1 && (jval & 1) == 1) {
                    j += 2;
                    continue;
                }

                // 如果i对应偶数，j也对应偶数，那么i进入下一次遍历，j不变，继续对比
                if ((ival & 1) != 1 && (jval & 1) != 1) {
                    i += 2;
                }
            }

            return A;

        }

        /**
         * 6 ms	 -----------》 30%
         * 39.4 MB --------》  97%
         *
         * @param A
         * @return
         */
        public int[] sortArrayByParityII(int[] A) {
            int size = A.length;
            if (size <= 1) {
                return A;
            }
            int i = 0, j = 1;

            while (i < size && j < size) {

                // 下标为奇数
                if ((i & 1) == 1) {
                    if ((A[i] & 1) != 1) {
                        if ((A[j] & 1) != 1) {
                            j++;
                        } else {
                            swap(i, j, A);
                            i++;
                        }
                    } else {
                        i++;
                        j = i + 1;
                    }
                } else {
                    if ((A[i] & 1) == 1) {
                        if ((A[j] & 1) == 1) {
                            j++;
                        } else {
                            swap(i, j, A);
                            i++;
                        }
                    } else {
                        i++;
                        j = i + 1;
                    }
                }
            }
            return A;
        }

        private void swap(int i, int j, int[] A) {
            if (i == j) return;
            int ival = A[i];
            A[i] = A[j];
            A[j] = ival;
        }
    }
}
