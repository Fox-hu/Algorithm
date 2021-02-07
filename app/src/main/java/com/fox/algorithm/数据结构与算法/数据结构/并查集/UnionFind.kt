package com.fox.algorithm.数据结构与算法.数据结构.并查集

/**
 * @Author Fox
 * @Date 2020/8/27 21:40
 * 这个并查集是用来解决连接关系的
 * 用数组进行存储，数组中存储的内容即是每个集合的根节点
 * 每个集合的根节点有且只有一个 没有多层结构
 */
abstract class UnionFind(capacity: Int) {

    protected lateinit var parents: IntArray

    init {
        if (capacity < 0) throw IllegalArgumentException("capacity must be >=1")
        parents = IntArray(capacity).apply {
            for (i in indices) {
                this[i] = i
            }
        }
    }

    /**
     * 查找v所属的集合
     * 就是v的根节点 也就是在数组中index为v所存储的内容
     */
    abstract fun find(v: Int): Int

    /**
     * 连接两个集合
     * 将v1的父节点变为v2的父节点 同时 所有v1的节点都要变
     */
    abstract fun union(v1: Int, v2: Int)

    fun isSame(v1: Int, v2: Int): Boolean {
        return find(v1) == find(v2)
    }

    protected fun rangeCheck(size: Int) {
        if (size < 0 || size > parents.size) throw IllegalArgumentException("range out of bounds")
    }

}