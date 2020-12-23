package com.kangf.leetcode.day;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _171_Excel表列序号 {

    public static void main(String[] args) {
        System.out.println("num === " + new Solution().titleToNumber("AAA"));
    }

    private static class Solution {
        // A    1
        // AB   26 * 1 + 2
        // ZY   26 * 26 + 25  701
        // ZZ   26 * 26 + 26  702
        // AAA  (26 * 1 + 1) * 26 + 1
        // ABA  (26 * 1 + 2) * 26 + 1
        // ZZZ  (26 * 26 + 26) * 26 + 26
        public int titleToNumber(String s) {

            if (s.isEmpty()) return -1;

            char[] c = s.toCharArray();

            int carryNum = 0;

            for (char value : c) {
                carryNum = carryNum * 26 + (value - 'A' + 1);
            }


            return carryNum;
        }
    }
}
