package com.fox.algorithm.dataStructure.queue

import com.fox.algorithm.dataStructure.list.SampleDoubleLinkedList

/**
 * @Author fox
 * @Date 2020/2/21 21:21
 */
class SampleQueue<E> {
    private val list = SampleDoubleLinkedList<E>()

    fun size(): Int = list.size()

    fun isEmpty(): Boolean = list.isEmpty()

    fun enQueue(element: E) {
        list.add(element)
    }

    fun deQueue(): E? = list.remove(0)

    fun front(): E? = list.get(0)
}