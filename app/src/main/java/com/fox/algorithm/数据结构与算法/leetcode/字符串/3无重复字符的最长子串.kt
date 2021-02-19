package com.fox.algorithm.数据结构与算法.leetcode.字符串

/**
 * @Author Fox
 * @Date 2020/10/12 21:17
 */

/*https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    val map = hashMapOf<Char, Int>() // key是字符 value是key字符所在的数组下标
    var max = 0 //滑动窗口右指针
    var left = 0 //滑动窗口左指针

    //使用滑动窗口遍历字符串
    //1.如果当前字符c没有记录 说明没有重复 调整右边界
    //2.如果当前字符c以及被记录了 说明已经有了重复字符 调整左边界，再调整右边界
    //3.注意左右边界都要和历史最大比较
    for (i in s.indices) {
        if (map.containsKey(s[i])) {
            left = Math.max(left, map[s[i]]!! + 1)
        }
        map[s[i]] = i
        max = Math.max(max, i - left + 1)
    }
    return max

}
