package com.fox.algorithm.数据结构与算法.leetcode.其他

/**
 * @Author Fox
 * @Date 2021/3/20 11:21
 */

/*https://leetcode-cn.com/problems/palindrome-number/
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。*/

fun isPalindrome(x: Int): Boolean {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false

    var temp = x
    var palindrome = 0

    while (temp > palindrome) {
        palindrome = palindrome * 10 + temp % 10
        temp = temp / 10
    }

    return temp == palindrome || temp == palindrome / 10
}