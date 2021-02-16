package com.fox.algorithm.程序员面试金典._01字符串

/**
 * @Author Fox
 * @Date 2020/10/28 22:16
 */
/*链接：https://leetcode-cn.com/problems/zero-matrix-lcci
编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
示例 1：
输入：
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出：
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

示例 2：
输入：
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出：
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]*/

// 这道题目的陷阱在于 如果一边遍历一边置0 则最后整个矩阵都会被置0
// 思路在于使用一个二维数组 将为0的位置先进行标记 全部遍历完之后才 进行置0操作
fun setZeroes(matrix: Array<IntArray>) {
    val rowArray = BooleanArray(matrix.size)
    val columnArray = BooleanArray(matrix[0].size)

    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == 0) {
                rowArray[i] = true
                columnArray[j] = true
            }
        }
    }

    //空置行
    for (i in rowArray.indices) {
        if (rowArray[i]) {
            for (j in matrix[0].indices) {
                matrix[i][j] = 0
            }
        }
    }

    //空置列
    for (j in columnArray.indices) {
        if (columnArray[j]) {
            for (i in matrix.indices) {
                matrix[i][j] = 0
            }
        }
    }
}