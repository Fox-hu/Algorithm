package com.fox.algorithm.程序员面试金典._01字符串

/**
 * @Author Fox
 * @Date 2020/10/28 22:41
 */
//链接：https://leetcode-cn.com/problems/string-rotation-lcci
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
//只调用一次检查子串的方法吗？
//示例1:
// 输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
//示例2:
//
// 输入：s1 = "aa", s2 = "aba"
// 输出：False
//提示：
//字符串长度在[0, 100000]范围内。
class _0109_字符串轮转 {

    // 解题思路在于 如果s2是s1旋转而来 则s1+s1中就一定包含了s2
    fun isFlipedString(s1: String, s2: String): Boolean {
        return s1.length == s2.length && (s1 + s1).contains(s2)
    }
}