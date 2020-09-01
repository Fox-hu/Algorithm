package com.fox.algorithm.dataStructure.sort


import com.fox.algorithm.sampleDataStructure.tools.Asserts
import com.fox.algorithm.sampleDataStructure.tools.Integers
import java.util.*

//测试用例
fun main() {
    val array = arrayOf(7, 3, 5, 8, 6, 7, 4, 5)
//    testSorts(array, InsertionSort())
}


fun testSorts(array: Array<Int>, vararg sorts: Sort<Int>) {
    for (sort in sorts) {
        val newArray = Integers.copy(array)
        sort.sort(newArray)
        Asserts.test(Integers.isAscOrder(newArray))
    }
    Arrays.sort(sorts)
    for (sort in sorts) {
        println(sort)
    }
}
