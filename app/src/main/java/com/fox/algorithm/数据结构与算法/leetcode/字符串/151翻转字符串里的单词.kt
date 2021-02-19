package com.fox.algorithm.数据结构与算法.leetcode.字符串

import java.util.*

/**
 * @Author fox.hu
 * @Date 2021/2/19 14:24
 */
/* https://leetcode-cn.com/problems/reverse-words-in-a-string
给定一个字符串，逐个翻转字符串中的每个单词。
说明：
无空格字符构成一个 单词 。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 
示例 1：
输入："the sky is blue"
输出："blue is sky the"

示例 2：
输入："  hello world!  "
输出："world! hello"
解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入："a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

示例 4：
输入：s = "  Bob    Loves  Alice   "
输出："Alice Loves Bob"

示例 5：
输入：s = "Alice does not even like bob"
输出："bob like even not does Alice"

提示：
1 <= s.length <= 104
s 包含英文大小写字母、数字和空格 ' '
s 中至少存在一个单词
 
进阶：
请尝试使用 O(1) 额外空间复杂度的原地解法。
*/

/*使用双端队列解决
1.将字符串左右的空格处理掉
2.沿着字符串一个一个单词处理 将单词压入队列的头部
3.将队列转成字符串即可
 */
fun reverseWords(s: String): String {
    var left = 0
    var right = s.length - 1

    while (left <= right && s[left] == ' ') {
        left++
    }

    while (left <= right && s[right] == ' ') {
        right--
    }
    val deque = ArrayDeque<String>()
    val word = StringBuilder()

    while (left <= right) {
        val c = s[left]
        if (word.isNotEmpty() && c == ' ') {
            deque.offerFirst(word.toString())
            //记得清空word
            word.setLength(0)
        } else if (c != ' ') {
            word.append(c)
        }
        left++
    }
    //这个不能少 最后一个单词
    deque.offerFirst(word.toString())
    return deque.joinToString(separator = " ")
}
