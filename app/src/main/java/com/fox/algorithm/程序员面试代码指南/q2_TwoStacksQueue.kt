package com.fox.algorithm.程序员面试代码指南

import java.util.*

/**
 * 编写一个类，用两个栈实现队列，并支持队列的基本操作（add,poll,peek）
 */
class q2_TwoStacksQueue {
    private val stackPush: Stack<Int>
    private val stackPop: Stack<Int>

    init {
        stackPush = Stack()
        stackPop = Stack()
    }

    fun add(pushInt: Int) {
        stackPush.add(pushInt)
    }

    fun pop(): Int {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw RuntimeException("queue is null")
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop())
            }
        }
        return stackPop.pop()
    }
}
