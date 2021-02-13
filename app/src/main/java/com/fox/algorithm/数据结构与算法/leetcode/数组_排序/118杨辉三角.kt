package com.fox.algorithm.数据结构与算法.leetcode.数组_排序

import java.util.*

/**
 * @author fox.hu
 * @date 2018/8/28
 */
/*在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 5
输出:
       [1],
      [1,1],
     [1,2,1],
    [1,3,3,1],
   [1,4,6,4,1]*/

fun generate(numRows: Int): List<List<Int>> {
    if (numRows == 0) {
        return ArrayList()
    }
    val ret: MutableList<List<Int>> = ArrayList(numRows)
    for (i in 0 until numRows) {
        val row: MutableList<Int> = ArrayList()
        //第一行和第二行特殊 为1
        if (i == 0) {
            row.add(1)
        } else if (i == 1) {
            row.add(1)
            row.add(1)
        } else {
            for (j in 0..i) {
                if (j == 0 || j == i) {
                    row.add(1)
                } else {
                    //此处注意 是i-1
                    val uperList = ret[i - 1]
                    row.add(uperList[j - 1] + uperList[j])
                }
            }
        }
        ret.add(row)
    }
    return ret
}

fun getRow(rowIndex: Int): List<Int> {
    val integers = arrayOfNulls<Int>(rowIndex + 1)
    Arrays.fill(integers, 0)
    integers[0] = 1
    for (i in 1 until integers.size) {
        for (j in i downTo 1) {
            integers[j] = integers[j]!! + integers[j - 1]!!
        }
    }
    return Arrays.asList<Int>(*integers)
}
