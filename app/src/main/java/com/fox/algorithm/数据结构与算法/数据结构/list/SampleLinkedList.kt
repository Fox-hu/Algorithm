package com.fox.algorithm.数据结构与算法.数据结构.list


/**
 * @Author fox
 * @Date 2020/2/18 16:11
 */

class SampleLinkedList<E> : SampleAbstractList<E>() {

    //使用虚拟头节点 简化当index为0时的逻辑
    private var firstNode: Node<E> = Node(null, null)

    private class Node<E>(var element: E?, var next: Node<E>?) {

        override fun toString(): String {
            val sb = StringBuilder()
            sb.append("_").append(element).append("_")
            next?.let {
                sb.append(it.element)
            } ?: sb.append("null")
            return sb.toString()
        }
    }

    private fun node(index: Int): Node<E>? {
        checkRange(index)
        var node = firstNode.next
        //这个地方要用until 最后一项不在范围内
        for (i in 0 until index) {
            node = node?.next
        }
        return node
    }

    override fun add(index: Int, element: E?) {
        checkRangeBeforeAdd(index)
        val prev = if (index == 0) firstNode else node(index - 1)
        val next = prev?.next
        prev?.next = Node(element, next)
        size++
    }

    override fun remove(index: Int): E? {
        checkRange(index)
        val prev = if (index == 0) firstNode else node(index - 1)
        val node = prev?.next
        prev?.next = node?.next
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
        var node = firstNode.next
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
        firstNode.next = null
        size = 0
    }

    override fun toString(): String {
        val string = StringBuilder()
        string.append("size=").append(size).append(", [")
        var node = firstNode.next
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
