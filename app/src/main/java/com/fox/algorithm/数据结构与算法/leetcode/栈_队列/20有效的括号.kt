package com.fox.algorithm.数据结构与算法.leetcode.栈_队列

import java.util.*

/**
 * @Author Fox
 * @Date 2021/3/18 11:03
 */
/*https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
输入：s = "()"
输出：true
 */
fun isValid(s: String): Boolean {
    if (s.length % 2 == 1) return false
    //注意这里的key value 是反过来的
    val map = hashMapOf(']' to '[', ')' to '(', '}' to '{')
    val stack = LinkedList<Char>()

    for (i in s.indices) {
        val ch = s[i]
        if (map.containsKey(ch)) {
            if (stack.isEmpty() || stack.peek() != map[ch]) {
                return false
            }
            stack.pop()
        } else {
            stack.push(ch)
        }
    }
    return stack.isEmpty()
}