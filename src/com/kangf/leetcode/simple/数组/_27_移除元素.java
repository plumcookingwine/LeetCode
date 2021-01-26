package com.kangf.leetcode.simple.数组;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _27_移除元素 {

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(new Solution().removeElement(nums, 2));
    }

    private static class Solution {

        public int removeElement2(int[] nums, int val) {
            int first = 0;
            int last = nums.length;

            while (first < last) {
                if (nums[first] == val) {
                    nums[first] = nums[--last];
                } else {
                    first++;
                }
            }

            return last;
        }

        public int removeElement(int[] nums, int val) {

            if (nums.length == 0) return 0;
            if (nums.length == 1) {
                if (nums[0] == val) return 0;
                else return 1;
            }

            int first = 0;
            int last = nums.length - 1;
            boolean isSwap = false;

            while (first < last) {

                if (nums[last] == val) {
                    last--;
                    continue;
                }

                if (nums[first] == val) {
                    if (!isSwap) isSwap = true;
                    int tmp = nums[first];
                    nums[first] = nums[last];
                    nums[last] = tmp;
                    continue;
                }
                first++;
            }

            int count = 0;

            for (int num : nums) {
                if (num == val) {
                    break;
                }
                count++;
            }

            return count;
        }


    }

}
