package com.kangf.leetcode.simple.队列.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 提示：
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 用两个栈实现队列 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(3);
        int delete1 = queue.deleteHead();
        int delete2 = queue.deleteHead();
        int delete3 = queue.deleteHead();

        System.out.println("d1 == " + delete1);
        System.out.println("d2 == " + delete2);
        System.out.println("d3 == " + delete3);
    }

    private static class CQueue {


        private final Deque<Integer> stack1;
        private final Deque<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.addLast(value);
        }

        public int deleteHead() {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.pop());
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            return -1;
        }
    }
}
