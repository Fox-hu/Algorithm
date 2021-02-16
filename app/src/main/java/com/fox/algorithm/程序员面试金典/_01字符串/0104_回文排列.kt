package com.fox.algorithm.程序员面试金典._01字符串

/**
 * @Author Fox
 * @Date 2020/10/21 20:50
 */

/*链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
回文串不一定是字典当中的单词。

示例1：
输入："tactcoa"
输出：true（排列有"tacocat"、"atcocta"，等等）*/


//使用一个set 遍历该string 如果有该字符了 就删除这个字符 如果没有则添加
//如果这个字符是回文串 则遍历到最后 set中应该只剩0或者1
fun canPermutePalindrome(str: String): Boolean {
    val set = mutableSetOf<Char>()
    for (c in str) {
        if (set.contains(c)) {
            set.remove(c)
        } else {
            set.add(c)
        }
    }
    return set.size == 0 || set.size == 1
}
