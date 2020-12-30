package com.fox.algorithm.数据结构与算法.数据结构.union

/**
 * @Author Fox
 * @Date 2020/8/30 20:52
 * 树高超过两层
 */

open class UnionFind_QU(capacity: Int) : UnionFind(capacity) {

    override fun find(v: Int): Int {
        var value = v
        rangeCheck(value)
        while (value != parents[value]) {
            value = parents[value]
        }
        return value
    }

    /**
     * 将v1的根节点，嫁接到v2的根节点
     */
    override fun union(v1: Int, v2: Int) {
        val f1 = find(v1)
        val f2 = find(v2)
        if (f1 == f2) return
        parents[f1] = f2
    }

}