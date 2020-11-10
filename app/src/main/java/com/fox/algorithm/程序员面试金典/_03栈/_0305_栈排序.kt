package com.fox.algorithm.程序员面试金典._03栈

import java.util.*

/**
 * @Author Fox
 * @Date 2020/11/10 20:37
 */
//链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
//最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
class _0305_栈排序 {

    class SortedStack {

        val data = Stack<Int>()
        val help = Stack<Int>()

        fun push(x: Int) {
            if (!data.isEmpty() && x > data.peek()) {
                while (!data.isEmpty() && x > data.peek()) {
                    help.push(data.pop())
                }
                data.push(x)
                while (!help.isEmpty()) {
                    data.push(help.pop())
                }
            } else {
                data.push(x)
            }

        }

        fun pop() {
            if (!data.isEmpty()) {
                data.pop()
            }
        }

        fun peek(): Int {
            if (!data.isEmpty()) {
                return data.peek()
            } else {
                return -1
            }
        }

        fun isEmpty(): Boolean {
            return data.isEmpty()
        }
    }
}