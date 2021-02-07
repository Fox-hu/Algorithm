package com.fox.algorithm.数据结构与算法.数据结构.并查集

/**
 * @Author Fox
 * @Date 2020/8/27 22:05
 * 树的高度不超过2
 */
class UnionFind_QF(capacity: Int) : UnionFind(capacity) {

    /**
     * 父节点就是根节点
     */
    override fun find(v: Int): Int {
        rangeCheck(v)
        return parents[v]
    }

    /**
     * 将v1所在集合的所有元素，都嫁接到v2的父节点上
     */
    override fun union(v1: Int, v2: Int) {
        val p1 = find(v1)
        val p2 = find(v2)
        if (p1 == p2) return

        for (i in parents.indices) {
            if (parents[i] == p1) {
                parents[i] = p2
            }
        }
    }
}