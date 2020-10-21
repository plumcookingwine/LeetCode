package com.kangf.leetcode.simple.数组;

/***
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 来源：力扣（LeetCode）
 *
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 缺失的数字 {

    public static void main(String[] args) {

        int[] nums = {0};

        // 两种方法效率相同
        System.out.println("i === " + new Solution2().missingNumber(nums));
    }

    /**
     * 通过遍历查询不同数字
     * <p>
     * 0 ms	38.6 MB
     */
    private static class Solution {
        public int missingNumber(int[] nums) {

            for (int i = 0; i < nums[nums.length - 1]; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }

            return nums[nums.length - 1] + 1;
        }
    }


    /**
     * 通过判断当前数字与下一个数字的差值计算缺失数字
     * <p>
     * 0 ms	38.5 MB
     */
    private static class Solution2 {
        public int missingNumber(int[] nums) {
            if (nums[0] != 0) return 0;
            for (int i = 0; i < nums.length - 1; i++) {
                // 如果下一个数字 - 当前数字大于1， 那么当前数字的下一个数字就是缺失数字
                if (nums[i + 1] - nums[i] > 1) {
                    return nums[i] + 1;
                }
            }
            return nums[nums.length - 1] + 1;
        }
    }
}
