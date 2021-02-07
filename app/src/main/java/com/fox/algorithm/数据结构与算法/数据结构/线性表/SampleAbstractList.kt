package com.fox.algorithm.数据结构与算法.数据结构.线性表

/**
 * @Author fox
 * @Date 2020/2/18 17:04
 */
abstract class SampleAbstractList<E> : SampleList<E> {

    companion object {
        const val DEFAULT_ELEMENT_NOT_FOUND = -1
    }

    protected var size: Int = 0

    override fun size() = size

    override fun isEmpty(): Boolean = size() == 0

    override fun add(element: E?) {
        add(size, element)
    }

    override fun contains(element: E): Boolean {
        return indexOf(element) != DEFAULT_ELEMENT_NOT_FOUND
    }

    fun checkRangeBeforeAdd(index: Int) {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("index = $index,Size = $size")
        }
    }

    fun checkRange(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("index = $index,Size = $size")
        }
    }
}