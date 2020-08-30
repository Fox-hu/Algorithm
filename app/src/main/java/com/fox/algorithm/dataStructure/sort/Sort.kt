package com.fox.algorithm.dataStructure.sort

/**
 * @Author fox
 * @Date 2020/2/22 19:37
 */

fun swap(intArray: IntArray, i: Int, j: Int) {
    val temp = intArray[i]
    intArray[i] = intArray[j]
    intArray[j] = temp
}

//冒泡排序
fun bubbleSort(array: IntArray) {
    for (i in array.indices) {
        for (j in 0 until array.size - i - 1) {
            if (array[j] > array[j + 1]) {
                swap(array, j, j + 1)
            }
        }
    }
}

//插入排序
fun insertSort(array: IntArray) {
    for (i in array.indices) {
        for (j in i downTo 1) {
            if (array[j] < array[j - 1]) {
                swap(array, j, j - 1)
            }
        }
    }
}

fun main() {
    val intArray = intArrayOf(4, 6, 1, 5, 88, 22, 11)
    bubbleSort(intArray)
    intArray.forEach { print("[$it]") }
}