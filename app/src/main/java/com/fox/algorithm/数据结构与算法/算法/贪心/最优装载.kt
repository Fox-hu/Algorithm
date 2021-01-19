package com.fox.algorithm.数据结构与算法.算法.贪心

import java.util.*

/**
 * @Author Fox
 * @Date 2020/12/2 21:56
 */
//最优装载问题（加勒比海盗）
//海盗船的载重量为 W，每件古董的重量为 𝑤i，海盗们该如何把尽可能多数量的古董装上海盗船？
//比如 W 为 30，𝑤i 分别为 3、5、4、10、7、14、2、11


fun getMaxNum() {
    val weights = intArrayOf(3, 5, 4, 10, 7, 14, 2, 11).apply {
        Arrays.sort(this)
    }
    val capacity = 30
    var weight = 0
    var count = 0
    var i = 0
    while (i < weights.size && weight < capacity) {
        val newWeight = weight + weights[i]
        if (newWeight <= capacity) {
            weight = newWeight
            count += 1
            println(weights[i])
        }
        i += 1
    }
    println("一共选了${count}个")
}

fun main(){
    getMaxNum()
}