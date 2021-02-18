package com.fox.algorithm.数据结构与算法.leetcode.栈_队列

import java.util.*

/**
 * @Author fox.hu
 * @Date 2021/2/18 13:22
 */

/*链接：https://leetcode-cn.com/problems/min-stack
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

示例:
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

提示：
pop、top 和 getMin 操作总是在 非空栈 上调用。
*/

//利用两个栈来完成 一个正常栈A,一个用于存储正常栈的最小值栈B
//每次push一个值x的时候 取B中的顶部和x的最小值push到B中，pop时A\B都要pop
class MinStack {

    val stack: Stack<Int> = Stack()
    val min: Stack<Int> = Stack()

    fun push(x: Int) {
        stack.push(x)
        if (min.isEmpty()) {
            min.push(x)
        } else {
            min.push(Math.min(x, min.peek()))
        }
    }

    fun pop() {
        stack.pop()
        min.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return min.peek()
    }

}
