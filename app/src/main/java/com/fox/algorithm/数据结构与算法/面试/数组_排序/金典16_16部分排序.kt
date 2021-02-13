package com.fox.algorithm.数据结构与算法.面试.数组_排序

/**
 * @Author Fox
 * @Date 2021/2/13 9:52
 */

/*
https://leetcode-cn.com/problems/sub-sort-lcci/
给定一个整数数组，编写一个函数，找出索引m和n，
只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
示例：
输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
输出： [3,9]
提示：
0 <= len(array) <= 1000000
*/

/*
* 两边扫描法
* 先从左到右扫描 找到最大逆序对的位置
* 再从右到左边扫描 找到最大逆序对的位置
* */
fun subSort(array: IntArray): IntArray {
    if (array.size <= 1) return intArrayOf(-1, -1)
    //从左扫描到右 正序逐渐变大
    var max = array[0]
    //用来记录最右边的那个逆序对的位置
    var r = -1
    for (i in 1 until array.size) {
        if (array[i] >= max) {
            max = array[i]
        } else {
            r = i
        }
    }

    //从右扫描到左边 顺序逐渐变小
    var min = array.last()
    //用来记录最左边逆序对的位置
    var l = -1
    for (i in array.size - 1 downTo 0) {
        if (array[i] <= min) {
            min = array[i]
        } else {
            l = i
        }
    }
    return intArrayOf(l, r)
}