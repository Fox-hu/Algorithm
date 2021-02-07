package com.fox.algorithm.数据结构与算法.数据结构.排序


import java.util.*

//测试用例
fun main() {
    val array = arrayOf(7, 3, 5, 8, 6, 7, 4, 5)
    testSorts(array, SelectionSort())
}

fun testSorts(array: Array<Int>, vararg sorts: Sort<Int>) {
    for (sort in sorts) {
        val newArray = copy(array)
        sort.sort(newArray)
        test(isAscOrder(newArray))
    }
    Arrays.sort(sorts)
    for (sort in sorts) {
        println(sort)
    }
}
