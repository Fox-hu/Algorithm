package com.fox.algorithm.数据结构与算法.数据结构.queue

import com.fox.algorithm.数据结构与算法.数据结构.list.SampleLinkedList

/**
 * 双端队列
 * @Author fox
 * @Date 2020/2/22 11:43
 */
class SampleDeque<E> {
    val list = SampleLinkedList<E>()

    fun size() = list.size()

    fun isEmpty() = list.isEmpty()

    fun enQueueRear(element: E) = list.add(element)

    fun deQueueRear(element: E) = list.remove(list.size() - 1)

    fun enQueueFront(element: E) = list.add(0, element)

    fun deQueueFront(element: E) = list.remove(0)

    fun front() = list.get(0)

    fun rear() = list.get(list.size() - 1)

    fun clear() = list.clear()
}