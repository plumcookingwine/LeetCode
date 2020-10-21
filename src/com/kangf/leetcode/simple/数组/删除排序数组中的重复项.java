package com.kangf.leetcode.simple.数组;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("count == " + new Solution().removeDuplicates(nums));
    }


    /**
     * 双指针
     * 1 ms
     * 40 MB
     */
    private static class Solution {
        public int removeDuplicates(int[] nums) {

            if (nums.length < 2) {
                return 0;
            }

            // 需要修改的下标
            int left = 1;

            // 移动下标 ，根据此下标判断是否与上一个元素重复
            int move = 1;

            while (left < nums.length && move < nums.length) {
                // 上一个数字
                int prvVal = nums[left - 1];
                // 代表重复了，根据题目规则 ，数组为递增数组，所以如果出现小于0的结果，也是重复项
                // 有重复的就move+1，继续判断
                if (nums[move] - prvVal <= 0) {
                    move++;
                } else {
                    // 如果不是重复，重新赋值
                    nums[left] = nums[move];
                    left++;
                    move++;
                }
            }

            for (int num : nums) {
                System.out.print(num);
            }

            return left;
        }
    }
}

