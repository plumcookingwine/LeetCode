package com.kangf.leetcode.simple.数组;

/**
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1必须小于index2。
 * <p>
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数之和2_输入有序数组 {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86, 88, 92, 124, 125, 136, 168, 173, 173, 180, 199, 212, 221, 227, 230, 277, 282, 306, 314, 316, 321, 325, 328, 336, 337, 363, 365, 368, 370, 370, 371, 375, 384, 387, 394, 400, 404, 414, 422, 422, 427, 430, 435, 457, 493, 506, 527, 531, 538, 541, 546, 568, 583, 585, 587, 650, 652, 677, 691, 730, 737, 740, 751, 755, 764, 778, 783, 785, 789, 794, 803, 809, 815, 847, 858, 863, 863, 874, 887, 896, 916, 920, 926, 927, 930, 933, 957, 981, 997};

        for (int i : new Solution().twoSum2(nums, 542)) {
            System.out.print(i + "    ");
        }

    }

    private static class Solution {

        public int[] twoSum2(int[] numbers, int target) {

            int[] a = new int[2];

            int end = numbers.length - 1;
            int start = 0;

            while (end > start) {
                int sum = numbers[start] + numbers[end];
                if (sum == target) {
                    a[0] = start + 1;
                    a[1] = end + 1;
                    return a;
                }

                if(sum > target) {
                    end--;
                    continue;
                }

                start++;

            }

            return a;

        }


        public int[] twoSum(int[] numbers, int target) {
            int[] a = new int[2];

            int start = 0;
            int end = numbers.length - 1;

            final int lastIndex = end;

            for (int i = 0; i < lastIndex; i++) {
                int sum = numbers[i] + numbers[lastIndex];
                if (sum > target) {
                    break;
                }

                if (sum < target) {
                    start++;
                    continue;
                }

                if (sum == target) {
                    a[0] = i + 1;
                    a[1] = numbers.length;
                    return a;
                }

            }


            for (int i = lastIndex; i > start; i--) {
                int sum = numbers[start] + numbers[i];


                if (sum < target) {
                    break;
                }

                if (sum > target) {
                    end--;
                    continue;
                }

                if (sum == target) {
                    a[0] = start + 1;
                    a[1] = i + 1;
                    return a;
                }
            }

            end++;

            for (int i = start; i < end + 1; i++) {

                for (int j = i + 1; j < end; j++) {
                    int sum = numbers[i] + numbers[j];
                    if (sum == target) {
                        a[0] = i + 1;
                        a[1] = j + 1;
                        return a;
                    }
                }


            }

            return a;
        }
    }
}
