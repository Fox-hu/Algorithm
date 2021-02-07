package com.fox.algorithm.数据结构与算法.数据结构.并查集

/**
 * @Author Fox
 * @Date 2020/8/30 20:52
 * 基于quick_ouion 基于size的优化 将树低的嫁接到树高的上
 */

class UnionFind_QU_S(capacity: Int) : UnionFind_QU(capacity) {

    /**
     * 这个size是用来存储每个树的高度的 一开始每个树高都是1
     */
    val size = IntArray(capacity) { 1 }

    /**
     * 将v1的根节点，嫁接到v2的根节点
     */
    override fun union(v1: Int, v2: Int) {
        val f1 = find(v1)
        val f2 = find(v2)
        if (f1 == f2) return
        if (size[f1] < size[f2]) {
            parents[f1] = f2
            //嫁接后 树高也随着增加
            size[f2] += size[f1]
        } else {
            parents[f2] = f1
            size[f1] += size[f2]
        }
    }

}