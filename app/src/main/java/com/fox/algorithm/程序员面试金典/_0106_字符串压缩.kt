package com.fox.algorithm.程序员面试金典

/**
 * @Author Fox
 * @Date 2020/10/21 22:08
 */
//链接：https://leetcode-cn.com/problems/compress-string-lcci
//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
//若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
//示例1:
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"

//示例2:
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
//提示：
//字符串长度在[0, 50000]范围内
class _0106_字符串压缩 {
    fun compressString(str: String): String {
        if (str.isEmpty()) return str

        val answer = StringBuilder()
        var char = str[0]
        var cnt = 1
        //细节点1 这个地方要从1开始 因为char = str[0] cnt = 1相当于已经遍历了第0个元素
        for (i in 1 until str.length) {
            if (char == str[i]) {
                cnt++
            } else {
                answer.append(char).append(cnt)
                char = str[i]
                cnt = 1
            }
        }
        //细节点2 最后一次循环的char和cnt 别漏了
        answer.append(char).append(cnt)
        //细节点3 是 >= ，参照当str为bb的时候
        return if (answer.toString().length >= str.length) str else answer.toString()
    }
}