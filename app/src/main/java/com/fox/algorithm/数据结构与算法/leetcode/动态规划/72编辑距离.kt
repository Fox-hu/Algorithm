package com.fox.algorithm.数据结构与算法.leetcode.动态规划

/**
 * @Author fox.hu
 * @Date 2021/2/20 14:01
 */

/*链接：https://leetcode-cn.com/problems/edit-distance
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
插入一个字符 删除一个字符 替换一个字符
示例 1：
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2：
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 
提示：
0 <= word1.length, word2.length <= 500
word1 和 word2 由小写英文字母组成
*/

/*
假设字符串1("mice")为s1,它的长度为n1;字符串2("arise")为s2,它的长度为n2
dp是大小为(n1+1)*(n2+1) 的二维数组
dp[i][j]代表 s1[0,i)转换成s2[0,j)的最少操作数
s1[0,i)是由s1的前i个字符组成的子串
s2[0,j)是由s2的前j个字符组成的子串
很显然，dp[n1][n2]就是我们要的答案，就是s1[0,n1)转换成s2[0,n2)的最少操作数
也就是s1转换成s2的最少操作数
根据题意
* 删除字符操作 -> dp[i][j] -> dp[i-1][j] +1 对应值dp[i][j]的左边值
* 添加字符操作 -> dp[i][j] -> dp[i][j-1] +1 对应值dp[i][j]的上边值
* 替换字符操作 -> 1.当s1[i-1] == s[j-1]时 则dp[i][j] = dp[i-1][j-1]
*                2.当s1[i-1] != s[j-1]时 则dp[i][j] = dp[i-1][j-1]+1
* */
fun minDistance(word1: String, word2: String): Int {
    //dp的取值范围是[word1.length+1][word2.length+1] 必须保证第0行和第0列有值 否则无法进行推导
    val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
    val cs1 = word1.toCharArray()
    val cs2 = word2.toCharArray()
    for (i in 0..cs1.size) {
        for (j in 0..cs2.size) {
            when {
                i == 0 && j == 0 -> dp[0][0] = 0
                i == 0 -> dp[0][j] = j
                j == 0 -> dp[i][0] = i
                else -> {
                    //四种情况
                    val left = dp[i][j - 1] + 1
                    val top = dp[i - 1][j] + 1
                    val leftTop = if (cs1[i - 1] == cs2[j - 1]) {
                        dp[i - 1][j - 1]
                    } else {
                        dp[i - 1][j - 1] + 1
                    }
                    dp[i][j] = Math.min(Math.min(left, top), leftTop)
                }
            }
        }
    }
    return dp[cs1.size][cs2.size]
}