package com.fox.algorithm.数据结构与算法.数据结构.sort

import java.util.*

/**
 * @Author Fox
 * @Date 2020/9/1 21:47
 */
fun test(value: Boolean) {
    try {
        if (!value) {
            throw Exception("测试未通过")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun random(count: Int, min: Int, max: Int): Array<Int?> {
    if (count <= 0 || min > max) {
        throw IllegalArgumentException()
    }
    val array = arrayOfNulls<Int>(count)
    val delta = max - min + 1
    for (i in 0 until count) {
        array[i] = min + (Math.random() * delta).toInt()
    }
    return array
}

fun combine(array1: Array<Int?>?, array2: Array<Int?>?): Array<Int?>? {
    if (array1 == null || array2 == null) {
        return null
    }
    val array = arrayOfNulls<Int>(array1.size + array2.size)
    for (i in array1.indices) {
        array[i] = array1[i]
    }
    for (i in array2.indices) {
        array[i + array1.size] = array2[i]
    }
    return array
}

fun same(count: Int, unSameCount: Int): Array<Int?>? {
    if (count <= 0 || unSameCount > count) {
        return null
    }
    val array = arrayOfNulls<Int>(count)
    for (i in 0 until unSameCount) {
        array[i] = unSameCount - i
    }
    for (i in unSameCount until count) {
        array[i] = unSameCount + 1
    }
    return array
}

fun headTailAscOrder(min: Int, max: Int, disorderCount: Int): Array<Int?>? {
    val array = ascOrder(min, max)
    if (disorderCount > array!!.size) {
        return array
    }
    val begin = array.size - disorderCount shr 1
    reverse(array, begin, begin + disorderCount)
    return array
}

fun centerAscOrder(min: Int, max: Int, disorderCount: Int): Array<Int?>? {
    val array = ascOrder(min, max)
    if (disorderCount > array!!.size) {
        return array
    }
    val left = disorderCount shr 1
    reverse(array, 0, left)
    val right = disorderCount - left
    reverse(array, array.size - right, array.size)
    return array
}

fun headAscOrder(min: Int, max: Int, disorderCount: Int): Array<Int?>? {
    val array = ascOrder(min, max)
    if (disorderCount > array!!.size) {
        return array
    }
    reverse(array, array.size - disorderCount, array.size)
    return array
}

fun tailAscOrder(min: Int, max: Int, disorderCount: Int): Array<Int?>? {
    val array = ascOrder(min, max)
    if (disorderCount > array!!.size) {
        return array
    }
    reverse(array, 0, disorderCount)
    return array
}

fun ascOrder(min: Int, max: Int): Array<Int?>? {
    var min = min
    if (min > max) {
        return null
    }
    val array = arrayOfNulls<Int>(max - min + 1)
    for (i in array.indices) {
        array[i] = min++
    }
    return array
}

fun descOrder(min: Int, max: Int): Array<Int?>? {
    var max = max
    if (min > max) {
        return null
    }
    val array = arrayOfNulls<Int>(max - min + 1)
    for (i in array.indices) {
        array[i] = max--
    }
    return array
}

/**
 * 反转一个数组，索引范围是[begin, end)
 */
fun reverse(array: Array<Int?>?, begin: Int, end: Int) {
    val count = end - begin shr 1
    val sum = begin + end - 1
    for (i in begin until begin + count) {
        val j = sum - i
        val tmp = array!![i]
        array[i] = array[j]
        array[j] = tmp
    }
}

fun copy(array: Array<Int>): Array<Int>? {
    return Arrays.copyOf(array, array.size)
}

fun isAscOrder(array: Array<Int>?): Boolean {
    if (array == null || array.isEmpty()) {
        return false
    }
    for (i in 1 until array.size) {
        if (array[i - 1] > array[i]) {
            return false
        }
    }
    return true
}

fun println(array: Array<Int?>?) {
    if (array == null) {
        return
    }
    val string = StringBuilder()
    for (i in array.indices) {
        if (i != 0) {
            string.append("_")
        }
        string.append(array[i])
    }
    println(string)
}
