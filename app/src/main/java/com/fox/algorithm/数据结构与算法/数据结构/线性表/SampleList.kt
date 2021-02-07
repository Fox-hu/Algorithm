package com.fox.algorithm.数据结构与算法.数据结构.线性表

/**
 * @Author fox
 * @Date 2020/2/18 16:23
 */
interface SampleList<E> {

    fun size(): Int

    fun isEmpty(): Boolean

    fun contains(element: E): Boolean

    fun add(element: E?)

    fun add(index: Int, element: E?)

    fun remove(index: Int): E?

    fun get(index: Int): E?

    fun set(index: Int, element: E?): E?

    fun indexOf(element: E?): Int

    fun clear()
}