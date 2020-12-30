package com.fox.algorithm.数据结构与算法.数据结构.stack

import com.fox.algorithm.数据结构与算法.数据结构.list.SampleArrayList

/**
 * @Author fox
 * @Date 2020/2/21 12:56
 */
class SampleStack<E> {

    val list = SampleArrayList<E>()

    fun push(element: E) = list.add(element)

    fun pop(): E? = list.remove(list.size() - 1)

    fun top(): E? = list.get(list.size() - 1)
}