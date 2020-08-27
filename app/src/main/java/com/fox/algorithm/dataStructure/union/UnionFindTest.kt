package com.fox.algorithm.dataStructure.union

/**
 * @Author Fox
 * @Date 2020/8/27 22:11
 */

fun main() {
    val union_QF = UnionFind_QF(12)
    union_QF.apply {
        union(0, 1)
        union(1, 2)
        union(2, 3)
        union(4, 5)
        union(4, 6)

    }

    println(union_QF.find(2))
    println(union_QF.isSame(1, 3))
    println(union_QF.isSame(5, 3))
    println(union_QF.isSame(5, 6))

}
