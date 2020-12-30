package com.fox.algorithm.数据结构与算法.数据结构.queue

import kotlin.math.max


/**
 * 循环队列（基于数组）
 * @Author fox
 * @Date 2020/2/22 12:35
 */
class SampleCircleQueue<E>(capacity: Int = DEFAULT_CAPACITY) {

    companion object {
        const val DEFAULT_CAPACITY = 10
    }

    private var size: Int = 0

    private var front: Int = 0

    private var elements: Array<E?> = Array<Any>(max(capacity, DEFAULT_CAPACITY)) {} as Array<E?>

    fun size() = size

    fun isEmpty() = size == 0

    fun enQueue(element: E) {
        ensureCapacity(size + 1)
        elements[index(size)] = element
        size++
    }

    fun deQueue(): E? {
        val frontElement = front()
        elements[front] = null
        front = index(1)
        size--
        return frontElement
    }

    fun front() = elements[front]

    fun clear() {
        for (i in 0..size) {
            elements[index(i)] = null
        }
        front = 0
        size = 0
    }

    private fun ensureCapacity(capacity: Int) {
        val oldCapacity = elements.size
        if (oldCapacity >= capacity) return

        //扩容
        val newCapacity = oldCapacity * 2
        val newElements = Array<Any>(newCapacity) {} as Array<E?>
        //需要获取原数组的真实索引
        //如原数组的真实索引是 3 0 1 2，扩容后需要调整至0 1 2 3 4 5 6 7
        for (i in 0 until size) {
            newElements[i] = elements[index(i)]
        }
        elements = newElements
        front = 0
    }

    //获取i的实际位置
    private fun index(i: Int) = (i + front) % elements.size

    override fun toString(): String {
        val string = StringBuilder()
        string.append("capcacity=").append(elements.size)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [")
        for (i in elements.indices) {
            if (i != 0) {
                string.append(", ")
            }

            string.append(elements[i])
        }
        string.append("]")
        return string.toString()
    }
}