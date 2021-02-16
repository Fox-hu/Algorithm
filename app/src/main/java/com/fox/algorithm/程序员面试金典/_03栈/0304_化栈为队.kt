package com.fox.algorithm.程序员面试金典._03栈

import java.util.*

/**
 * @Author Fox
 * @Date 2020/11/10 20:07
 */
/*链接：https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci
实现一个MyQueue类，该类用两个栈来实现一个队列。
说明：
你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。*/

class MyQueue {
    //思路在于 在push时 使用pushStack来接收
    //在pop时 先看popStack有没有值 有的话直接返回popStack.pop()
    //如果popStack没有值 说明值全都在pushStack中 这时 将push栈的值全部压入到pop栈中
    //相当于将push栈逆序 这个时候从popStack中pop即可

    /** Initialize your data structure here. */
    private val pushStack = Stack<Int>()
    private val popStack = Stack<Int>()


    /** Push element x to the back of queue. */
    fun push(x: Int) {
        pushStack.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        peek()
        return popStack.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop())
            }
        }
        return popStack.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return popStack.isEmpty() && pushStack.isEmpty()
    }

}
