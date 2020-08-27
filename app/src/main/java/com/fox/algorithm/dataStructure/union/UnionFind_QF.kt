package com.fox.algorithm.dataStructure.union

/**
 * @Author Fox
 * @Date 2020/8/27 22:05
 */
class UnionFind_QF(capacity: Int) : UnionFind(capacity) {

    override fun find(v: Int): Int {
        rangeCheck(v)
        return parents[v]
    }

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