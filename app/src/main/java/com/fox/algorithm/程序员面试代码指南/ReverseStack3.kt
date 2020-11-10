package com.fox.algorithm.程序员面试代码指南

import java.util.*

/**
 * 仅仅使用递归函数来逆序一个栈
 * @Author fox
 * @Date 2020/1/18 12:00
 */

fun getAndRemoveLastElement(stack: Stack<Int>): Int {
    val result = stack.pop()
    return if (stack.empty()) {
        result
    } else {
        val last = getAndRemoveLastElement(stack)
        stack.push(result)
        last
    }
}

fun reverse(stack: Stack<Int>){
    if(!stack.empty()){
        val lastElement = getAndRemoveLastElement(stack)
        reverse(stack)
        stack.push(lastElement)
    }
}