package com.fox.algorithm.数据结构与算法.数据结构.sort

/**
 * @Author Fox
 * @Date 2020/9/7 23:00
 */
class BubbleSort<T : Comparable<T>> : Sort<T>() {

    override fun sort() {
        for (end in array.size - 1 downTo 1)
            for (begin in 1..end) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1)
                }
            }
    }
}

class BubbleSort1<T : Comparable<T>> : Sort<T>() {
    //如果内循环没有交换 说明是有序的 则下次外循环就可以跳过1次 直到内循环发生了交换为止
    override fun sort() {
        var end = array.size - 1
        while (end > 0) {
            var sortedIndex = 1
            for (begin in 1..end) {
                // if (array[begin] < array[begin - 1]) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1)
                    sortedIndex = begin
                }
            }
            end = sortedIndex
            end--
        }
    }
}