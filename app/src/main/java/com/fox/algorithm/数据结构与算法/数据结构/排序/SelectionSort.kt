package com.fox.algorithm.数据结构与算法.数据结构.排序

/**
 * @Author Fox
 * @Date 2020/9/16 22:05
 */
class SelectionSort<T : Comparable<T>> : Sort<T>() {

    override fun sort() {
        for (i in 0 until array.size) {
            for (j in i + 1 until array.size) {
                if (cmp(i, j) > 0) {
                    swap(i, j)
                }
            }
        }
    }

}

class SelectionSort1<T : Comparable<T>> : Sort<T>() {
    //每轮内循环只进行一次交换 省去了交换的开销
    override fun sort() {
        for (i in 0 until array.size) {
            var minIndex = i
            for (j in i + 1 until array.size) {
                if (cmp(minIndex, j) > 0) {
                    minIndex = j
                }
            }
            swap(i, minIndex)
        }
    }

}
