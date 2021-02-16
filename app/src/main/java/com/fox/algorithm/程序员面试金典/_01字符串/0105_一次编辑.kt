package com.fox.algorithm.程序员面试金典._01字符串

/**
 * @Author Fox
 * @Date 2020/10/21 21:14
 */

/*链接：https://leetcode-cn.com/problems/one-away-lcci
字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
示例 1:
输入:
first = "pale"
second = "ple"
输出: True
 
示例 2:
输入:
first = "pales"
second = "pal"
输出: False*/


fun oneEditAway(first: String, second: String): Boolean {
    val len1 = first.length
    val len2 = second.length
    if (Math.abs(len1 - len2) > 1) return false
    //保证 first的位数大于second 入口统一
    if (len2 > len1) return oneEditAway(second, first)

    for (i in second.indices) {
        if (first[i] != second[i]) {
            //主要思路是，只有一个地方需要修改，那么不妨定位到不同字符处。有以下两种情况
            //（1）长度相同：leetcode 与 leetkode。
            //那么我们需要找到 'c' 和 'k'，然后比较 'ode' 和 'ode' 是否相同。
            //（2）长度不同：leetcode 与 leetode。
            //我们发现 'c' 和 'o' 不相同，然后比较 'ode' 和 'ode' 是否相同。
            return first.substring(i + 1) == second.substring(if (len1 == len2) i + 1 else i)
        }
    }
    return true
}
