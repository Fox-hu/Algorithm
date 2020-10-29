package com.fox.algorithm.程序员面试金典.字符串

/**
 * @Author Fox
 * @Date 2020/10/19 22:34
 */
//链接:https://leetcode-cn.com/problems/is-unique-lcci/
//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//示例 1：
//输入: s = "leetcode"
//输出: false

//示例 2：
//输入: s = "abc"
//输出: true

//0 <= len(s) <= 100
//如果你不使用额外的数据结构，会很加分。

class _0101_判定字符是否唯一 {

    //使用set来完成
    fun isUnique(str: String): Boolean {
        val set = mutableSetOf<Char>()
        for (c in str) {
            set.add(c)
        }
        return set.size == str.length
    }

    //使用位运算来
    //使用两个long来代表一个128位的数字 每次出现一个字符时，将其对应的位数置为1 如果有重复的1则说明有重复的字符了
    //kotlin 中 shl 代表左移 and 是于运算 or 是或运算
    fun isUnique1(astr: String): Boolean {
        var low64: Long = 0
        var high64: Long = 0
        for (c in astr) {
            if (c.toInt() > 64) {
                //如果大于64 则放到高64位中 移到对应的位置中
                val highIndex = 1L shl (c.toInt() - 64)
                //将现有值与该index进行&计算 如果不为0 说明有重复的值
                if (highIndex and high64 != 0L) {
                    return false
                }
                high64 = high64 or highIndex
            } else {
                val lowIndex = 1L shl c.toInt()
                if (lowIndex and low64 != 0L) {
                    return false
                }
                low64 = low64 or lowIndex
            }
        }
        return true
    }

}