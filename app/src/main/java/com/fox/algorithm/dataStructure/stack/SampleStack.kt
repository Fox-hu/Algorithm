package com.fox.algorithm.dataStructure.stack

import com.fox.algorithm.dataStructure.list.SampleArrayList

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