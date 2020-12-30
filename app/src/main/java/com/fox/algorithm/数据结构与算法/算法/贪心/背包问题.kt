package com.fox.algorithm.数据结构与算法.算法.贪心

import java.util.*
import kotlin.Comparator

/**
 * @Author Fox
 * @Date 2020/12/16 11:23
 */
//有n件物品和一个最大承重的背包，每件物品的重量是wi,价值是vi，
//在保证总重量不超过W的前提下，将那几件物品装入背包，可以使背包的总价值最大？
//注意 每个物品只有一件
class 背包问题 {
    val articles = arrayOf(
            Article(35, 10), Article(30, 40),
            Article(60, 30), Article(50, 50),
            Article(40, 35), Article(10, 40),
            Article(25, 30)
    )
    //有三种思路来解决这个问题1.优先选择价值最大的 2.优先选择重量最轻的 3.优先选择价值密度最大的
    fun knapsack() {
        select("价值主导", Comparator { a1: Article, a2: Article -> a2.value - a1.value })
        select("重量主导", Comparator { a1: Article, a2: Article -> a1.weight - a2.weight })
        select("价值密度主导", Comparator { a1: Article, a2: Article -> java.lang.Double.compare(a2.valueDensity, a1.valueDensity) })
    }

    fun select(title: String, cmp: Comparator<Article>?) {
        Arrays.sort(articles, cmp)
        val capacity = 150
        var weight = 0
        var value = 0
        val selectedArticles: MutableList<Article> = LinkedList()
        run {
            var i = 0
            while (i < articles.size && weight < capacity) {
                val newWeight = weight + articles[i].weight
                if (newWeight <= capacity) {
                    weight = newWeight
                    value += articles[i].value
                    selectedArticles.add(articles[i])
                }
                i++
            }
        }
        println("【$title】")
        println("总价值：$value")
        for (i in selectedArticles.indices) {
            println(selectedArticles[i])
        }
        println("-----------------------------")
    }
}


class Article(var weight: Int, var value: Int) {
    var valueDensity: Double

    override fun toString(): String {
        return "Article [weight=$weight, value=$value, valueDensity=$valueDensity]"
    }

    init {
        valueDensity = value * 1.0 / weight
    }
}