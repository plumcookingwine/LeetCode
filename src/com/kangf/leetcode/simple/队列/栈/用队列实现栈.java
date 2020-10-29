package com.kangf.leetcode.simple.队列.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * <p>
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 用队列实现栈 {


    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(10);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();

        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    /**
     * 用两个队列实现一个栈
     */
    private static class MyStack2 {

        private Deque<Integer> deque1;
        private Deque<Integer> deque2;

        /**
         * Initialize your data structure here.
         */
        public MyStack2() {
            deque1 = new LinkedList<>();
            deque2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            deque2.offer(x);
            while (!deque1.isEmpty()) {
                deque2.offer(deque1.pop());
            }
            Deque<Integer> tmp = deque1;
            deque1 = deque2;
            deque2 = tmp;

        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return deque1.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return deque1.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return deque1.isEmpty();
        }
    }


    /**
     * 一个队列就可以实现栈
     */
    private static class MyStack {

        private final Deque<Integer> deque;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            deque = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            int size = deque.size();
            deque.offer(x);
            for (int i = 0; i < size; i++) {
                deque.offer(deque.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            Integer i = deque.poll();
            return i == null ? -1 : i;
        }

        /**
         * Get the top element.
         */
        public int top() {
            Integer i = deque.peek();
            return i == null ? -1 : i;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return deque.size() == 0;
        }
    }
}


