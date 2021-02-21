package com.fox.algorithm.数据结构与算法.leetcode.动态规划

/**
 * @Author fox.hu
 * @Date 2021/2/20 15:54
 */
/*https://leetcode-cn.com/problems/longest-palindromic-substring
给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"

示例 3：
输入：s = "a"
输出："a"

示例 4：
输入：s = "ac"
输出："a"

提示：
1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成
 */

/*
动态规划解法
假设字符串("babad")为s 长度为n
dp是大小为n*n的数组
dp[i][j]表示的是s[i,j]是否为回文串,存储为true、false
故dp的值可以分两种情况求出
1.当j-i+1 <=2时 dp[i][j] = s[i]==s[j]
2.当j-i+1 >2时 dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
遍历时 j < i时无意义  遍历的顺序应该是从由下往上 由左往右遍历
* */
fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return s
    val cs = s.toCharArray()
    val dp = Array(cs.size) { BooleanArray(cs.size) }
    var maxLength = 1
    var begin = 0

    for (i in cs.size - 1 downTo 0) {
        for (j in i until cs.size) {
            val length = j - i + 1
            if (length <= 2) {
                dp[i][j] = cs[i] == cs[j]
            } else {
                dp[i][j] = dp[i + 1][j - 1] && cs[i] == cs[j]
            }
            if (dp[i][j] && length > maxLength) {
                maxLength = length
                begin = i
            }
        }
    }
    return String(cs, begin, maxLength)
}

//中心扩散法
//需要考虑 奇偶回文子串都有可能
fun longestPalindrome1(s: String): String {
    if (s.isEmpty()) return ""
    var start: Int = 0
    var end: Int = 0

    for (i in s.indices) {
        //奇数回文子串最大长度
        val len1 = expandAroundCent(s, i, i)
        //偶数回文子串最大长度
        val len2 = expandAroundCent(s, i, i + 1)
        val max = Math.max(len1, len2)
        //如果此循环的max大于之前累计的max 则更新start end指针的值
        if (max > start - end) {
            start = i - (max - 1) / 2
            end = i + max / 2
        }
    }
    return s.substring(start, end + 1)
}

//以start end 为基础进行扩散 返回最大回文子串长度
fun expandAroundCent(s: String, left: Int, right: Int): Int {
    var tempLeft = left
    var tempRight = right
    while (tempLeft >= 0 && tempRight < s.length && s[tempLeft] == s[tempRight]) {
        tempLeft--
        tempRight++
    }
    //这个地方可以拿纸画一下 跳出循环后的最大回文子串的长度
    return tempRight - tempLeft - 1
}