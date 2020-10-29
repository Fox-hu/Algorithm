package com.fox.algorithm.程序员面试金典.字符串

/**
 * @Author Fox
 * @Date 2020/10/20 22:09
 */
//链接:https://leetcode-cn.com/problems/string-to-url-lcci/
//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
//示例1:
// 输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"

//示例2:
// 输入："               ", 5
// 输出："%20%20%20%20%20"
//提示：
//字符串长度在[0, 500000]范围内。
class _0103_URL化 {

    //StringBuilder方式进行
    fun replaceSpaces(str: String, length: Int): String {
        val stringBuilder = StringBuilder()
        for (i in 0 until length) {
            if (str[i] == ' ') {
                stringBuilder.append("%20")
            } else {
                stringBuilder.append(str[i])
            }
        }
        return stringBuilder.toString()
    }

    //使用string的api
    fun replaceSpaces1(str: String, length: Int): String {
        return str.substring(0, length).replace(" ", "%20")
    }
}