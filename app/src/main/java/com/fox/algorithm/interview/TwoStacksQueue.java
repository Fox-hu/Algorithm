package com.fox.algorithm.interview;

import java.util.Stack;

/**
 * 编写一个类，用两个栈实现队列，并支持队列的基本操作（add,poll,peek）
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int pushInt) {
        stackPush.add(pushInt);
    }

    public int pop() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is null");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
}
