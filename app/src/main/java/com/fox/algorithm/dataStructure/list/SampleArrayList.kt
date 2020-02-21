package com.fox.algorithm.dataStructure.list

import kotlin.math.max



/**
 * @Author fox
 * @Date 2020/2/17 15:58
 */
open class SampleArrayList<E>(capacity: Int = DEFAULT_CAPACITY) : SampleAbstractList<E>() {

    companion object {
        const val DEFAULT_CAPACITY = 16
    }

    private var elements: Array<E?> = Array<Any>(max(capacity, DEFAULT_CAPACITY)) {} as Array<E?>

    override fun add(index: Int, element: E?) {
        checkRangeBeforeAdd(index)

        ensureCapacity(size + 1)

        for (i in size - 1 downTo index) {
            elements[i + 1] = elements[i]
        }
        elements[index] = element
        size++
    }

    private fun ensureCapacity(capacity: Int) {
        val oldCapacity = elements.size
        if (oldCapacity >= capacity) return

        //扩容
        val newCapacity = oldCapacity * 2
        val newElements = Array<Any>(newCapacity) {} as Array<E?>
        elements.forEachIndexed { index: Int, i: E? -> newElements[index] = i }
        elements = newElements
    }

    override fun remove(index: Int): E? {
        checkRange(index)
        val old = elements[index]
        for (i in index + 1 until size) {
            elements[i - 1] = elements[i]
        }
        size--
        elements[size] = null
        return old
    }

    override fun get(index: Int): E? {
        checkRange(index)
        return elements[index]
    }

    override fun set(index: Int, element: E?): E? {
        checkRange(index)
        val old = elements[index]
        elements[index] = element
        return old
    }

    override fun indexOf(element: E?): Int {
        if (element == null) {  // 1
            for (i in 0 until size) {
                if (elements[i] == null) return i
            }
        } else {
            for (i in 0 until size) {
                if (element.equals(elements[i])) return i // n
            }
        }
        return DEFAULT_ELEMENT_NOT_FOUND
    }

    override fun clear() {
        for (i in 0..elements.size) {
            elements[i] = null
        }
        size = 0
    }

    override fun toString(): String {
        val string = StringBuilder()
        string.append("size=").append(size).append(", [")
        for (i in 0 until size) {
            if (i != 0) {
                string.append(", ")
            }
            string.append(elements[i])
        }
        string.append("]")
        return string.toString()
    }
}

