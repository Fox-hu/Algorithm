package com.fox.algorithm.程序员面试金典._03栈

import java.util.*

/**
 * @Author Fox
 * @Date 2020/11/9 21:56
 */
//链接：https://leetcode-cn.com/problems/min-stack-lcci
//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
//示例：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.

class _0302_栈的最小值 {

    class MinStack {

        //思路在于使用两个栈 一个记录数据 一个记录最小的值
        //注意  每次有入栈的操作时 这个记录最小值的栈也要进行入栈 如果当前入栈的值是最小 则入栈这个值 如果当前入栈的值不是最小 则入栈最小值栈的最上方一个
        //保证 两个栈的高度是一样的
        private val stack = Stack<Int>()
        private val minStack = Stack<Int>()

        fun push(x: Int) {
            stack.push(x)
            if (minStack.empty() || x < minStack.peek()) {
                minStack.push(x)
            } else {
                minStack.push(minStack.peek())
            }
        }

        fun pop() {
            stack.pop()
            minStack.pop()
        }

        fun top(): Int {
            return stack.peek()
        }

        fun getMin(): Int {
            return minStack.peek()
        }

    }
}