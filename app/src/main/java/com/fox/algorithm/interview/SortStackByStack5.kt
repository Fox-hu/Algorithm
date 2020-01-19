package com.fox.algorithm.interview

import java.util.*

/**
 * 使用一个辅助栈将一个已有栈排序
 * @Author fox
 * @Date 2020/1/19 20:41
 */
fun sortStackByStack(stack: Stack<Int>) {

    val help = Stack<Int>()
    while (!stack.isEmpty()) {
        val cur = stack.pop()
        while (!help.isEmpty() && cur > help.peek()) {
            stack.push(help.pop())
        }
        help.push(cur)
    }

    while (!help.isEmpty()) {
        stack.push(help.pop())
    }
}