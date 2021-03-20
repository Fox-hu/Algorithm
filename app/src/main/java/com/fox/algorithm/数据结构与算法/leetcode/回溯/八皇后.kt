package com.fox.algorithm.数据结构与算法.leetcode.回溯

import kotlin.math.abs

/**
 * @Author Fox
 * @Date 2020/11/30 21:58
 */

//因为棋盘是n*n的，使用一个数组即可表示棋盘内的皇后所在位置
//数组索引是行号 数组元素是列号
lateinit var cols: IntArray
var ways = 0 //n皇后共有多少种摆法

fun placeQueens(n: Int) {
    if (n < 1) return
    cols = IntArray(n)
    place(0)
    println("${n}皇后一共有${ways}种摆法")
}

private fun place(row: Int) {
    //如果走到这一行 说明已经找到了八皇后的一个解
    if (row == cols.size) {
        ways += 1
        show()
        return
    }
    for (col in cols.indices) {
        if (isValid(row, col)) {
            //如果不需要剪枝 则在第row行第col列摆放皇后
            cols[row] = col
            place(row + 1)
            //执行到这里 说明就已经在回溯了
        }
    }
}

//判断第row行和第col列是否需要剪枝
private fun isValid(row: Int, col: Int): Boolean {
    //从0到row行进行遍历
    for (i in 0 until row) {
        //如果前row行在第col列已经有摆放的皇后了 则需要跳过
        if (cols[i] == col) {
            println("[${row}][${col}]=false")
            return false
        }
        //如果斜线上有皇后 也需要跳过
        //斜线的数学公式就是 x1-x2 = (1或者-1)y1-y2或者
        //这里row是大于i的 row-i是大于1的
        if (row - i == abs(col - cols[i])) {
            println("[${row}][${col}]=false")
            return false
        }
    }

    println("[${row}][${col}]=true")
    return true
}

private fun show() {
    for (row in cols.indices) {
        for (col in cols.indices) {
            if (cols[row] == col) {
                print("1 ")
            } else {
                print("0 ")
            }
        }
        println()
    }
    println("--------------------------")
}

fun main(){
    placeQueens(8)
}
