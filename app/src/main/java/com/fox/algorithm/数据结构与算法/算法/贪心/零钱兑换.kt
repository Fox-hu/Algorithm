package com.fox.algorithm.数据结构与算法.算法.贪心

/**
 * @Author Fox
 * @Date 2020/12/16 10:04
 */
//假设有25分、10分、5分、1分的硬币，现在要找给客户41分的零钱，如何办到硬币个数最少？


//这里要求必须是升序排列，用于从大到小的取值
val faces = intArrayOf(1, 5, 10, 25)

fun coinChange(target: Int) {
    var money = target
    var coin = 0

    var i = faces.size - 1
    while (i >= 0) {
        if (money < faces[i]) {
            i -= 1
        } else {
            money -= faces[i]
            coin += 1
            println("face = ${faces[i]}")
        }
    }

    println("coins = $coin")
}

fun main(){
    coinChange(41)
}