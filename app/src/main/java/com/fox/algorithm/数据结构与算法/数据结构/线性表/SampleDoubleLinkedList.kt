package com.fox.algorithm.数据结构与算法.数据结构.线性表


/**
 * 双向链表
 * @Author fox
 * @Date 2020/2/18 16:11
 */

class SampleDoubleLinkedList<E> : SampleAbstractList<E>() {

    private var firstNode: Node<E>? = null
    private var lastNode: Node<E>? = null

    private class Node<E>(var element: E?, var prev: Node<E>?, var next: Node<E>?) {
        override fun toString(): String {
            val sb = StringBuilder()
            prev?.let {
                sb.append(it.element)
            } ?: sb.append("null")
            sb.append("_").append(element).append("_")
            next?.let {
                sb.append(it.element)
            } ?: sb.append("null")
            return sb.toString()
        }
    }

    private fun node(index: Int): Node<E>? {
        checkRange(index)
        var node: Node<E>?
        if (index < (size / 2)) {
            node = firstNode
            //这个地方要用until 最后一项不在范围内
            for (i in 0 until index) {
                node = node?.next
            }
        } else {
            node = lastNode
            for (i in size - 1 downTo index + 1) {
                node = node?.prev
            }
        }
        return node
    }

    override fun add(index: Int, element: E?) {
        //先连后断
        checkRangeBeforeAdd(index)
        if (index == size) {
            val oldLast = lastNode
            lastNode = Node(element, oldLast, null)
            if (oldLast == null) firstNode = lastNode else oldLast.next = lastNode
        } else {
            val next = node(index)
            val prev = next?.prev
            val node = Node(element, prev, next)
            next?.prev = node
            if (prev == null) firstNode = node else prev.next = node
        }
        size++
    }

    override fun remove(index: Int): E? {
        checkRange(index)
        val node = node(index)
        val prev = node?.prev
        val next = node?.next

        if (prev == null) firstNode = next else prev.next = next
        if (next == null) lastNode = prev else next.prev = prev

        size--
        return node?.element
    }

    override fun get(index: Int): E? = node(index)?.element

    override fun set(index: Int, element: E?): E? {
        val oldElement = node(index)?.element
        node(index)?.element = element
        return oldElement
    }

    override fun indexOf(element: E?): Int {
        var node = firstNode
        if (element == null) {
            for (i in 0 until size) {
                if (node?.element == null) {
                    return i
                }
                node = node.next
            }
        } else {
            for (i in 0 until size) {
                if (node?.element == element) {
                    return i
                }
                node = node?.next
            }
        }
        return DEFAULT_ELEMENT_NOT_FOUND
    }

    override fun clear() {
        firstNode = null
        lastNode = null
        size = 0
    }

    override fun toString(): String {
        val string = StringBuilder()
        string.append("size=").append(size).append(", [")
        var node = firstNode
        for (i in 0 until size) {
            if (i != 0) {
                string.append(", ")
            }
            string.append(node)
            node = node?.next
        }
        string.append("]")
        return string.toString()
    }
}

