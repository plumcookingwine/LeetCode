package com.kangf.leetcode.day;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _303_区域和检索 {

    public static void main(String[] args) {

        NumArray na = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));
    }

    private static class NumArray {

        private final int[] ans;

        public NumArray(int[] nums) {
            ans = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                ans[i + 1] = ans[i] + nums[i];
            }

        }

        public int sumRange(int i, int j) {
            return ans[j + 1] - ans[i];
        }
    }
}
