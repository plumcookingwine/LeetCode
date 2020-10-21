package com.kangf.leetcode.simple.数组;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 调整数组顺序 {

    public static void main(String[] args) {

        int a[] = new int[]{2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        int change[] = new Solution().exchange(a);
        for (int i : change) {
            System.out.print(i + "   ");
        }
    }


    private static class Solution {

        private void swap(int[] nums, int pos1, int pos2) {
            if (pos1 == pos2) {
                return;
            }
            int a = nums[pos1];
            nums[pos1] = nums[pos2];
            nums[pos2] = a;
        }

        /**
         * 判断奇数就跟左侧交换，
         * 或者判断偶数跟右侧交换
         * @param nums
         * @return
         */
        public int[] exchange(int[] nums) {

            int left = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 != 0) {
                    swap(nums, i, left);
                    left++;
                }
            }

            return nums;
        }


        /**
         * 暴力解法，浪费一个数组的内存
         * @param nums
         * @return
         */
        public int[] exchange2(int[] nums) {
            int[] a = new int[nums.length];

            int left = 0;
            int right = nums.length - 1;

            for (int num : nums) {
                if (num % 2 == 0) {
                    a[right] = num;
                    right--;
                } else {
                    a[left] = num;
                    left++;
                }
            }

            return a;
        }
    }
}
