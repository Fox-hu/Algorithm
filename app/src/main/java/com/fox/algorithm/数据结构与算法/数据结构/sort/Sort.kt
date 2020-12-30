package com.fox.algorithm.数据结构与算法.数据结构.sort

import java.text.DecimalFormat

abstract class Sort<T : Comparable<T>> : Comparable<Sort<T>> {

    protected lateinit var array: Array<T>
    private var cmpCount = 0
    private var swapCount = 0
    private var time: Long = 0
    private val fmt = DecimalFormat("#.00")

    fun sort(array: Array<T>?) {
        if (array == null || array.size < 2) {
            return
        }
        this.array = array
        val begin = System.currentTimeMillis()
        sort()
        time = System.currentTimeMillis() - begin
    }

    override fun compareTo(o: Sort<T>): Int {
        var result = (time - o.time).toInt()
        if (result != 0) return result
        result = cmpCount - o.cmpCount
        return if (result != 0) {
            result
        } else swapCount - o.swapCount
    }

    protected abstract fun sort()

    /*
     * 返回值等于0，代表 array[i1] == array[i2]
     * 返回值小于0，代表 array[i1] < array[i2]
     * 返回值大于0，代表 array[i1] > array[i2]
     */
    protected fun cmp(i1: Int, i2: Int): Int {
        cmpCount++
        return array[i1].compareTo(array[i2])
    }

    protected fun cmp(v1: T, v2: T): Int {
        cmpCount++
        return v1.compareTo(v2)
    }

    fun swap(i1: Int, i2: Int) {
        swapCount++
        val tmp = array[i1]
        array[i1] = array[i2]
        array[i2] = tmp
    }

    override fun toString(): String {
        val timeStr = "耗时：" + time / 1000.0 + "s(" + time + "ms)"
        val compareCountStr = "比较：" + numberString(cmpCount)
        val swapCountStr = "交换：" + numberString(swapCount)
        return "【${javaClass.simpleName}】\n $timeStr 	$compareCountStr	 $swapCountStr \n" +
                "------------------------------------------------------------------"
    }

    private fun numberString(number: Int): String {
        if (number < 10000) {
            return "" + number
        }
        return if (number < 100000000) {
            fmt.format(number / 10000.0) + "万"
        } else fmt.format(number / 100000000.0) + "亿"
    }
}