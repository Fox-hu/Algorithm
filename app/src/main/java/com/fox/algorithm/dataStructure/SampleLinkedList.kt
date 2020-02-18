package com.fox.algorithm.dataStructure


/**
 * @Author fox
 * @Date 2020/2/18 16:11
 */

class SampleLinkedList<E> : SampleAbstractList<E>() {

    private var firstNode: Node<E>? = null

    private class Node<E>(var element: E?, var next: Node<E>?) {

        override fun toString(): String {
            val sb = StringBuilder()
//            prev?.let {
//                sb.append(it.element)
//            } ?: sb.append("null")
            sb.append("_").append(element).append("_")
            next?.let {
                sb.append(it.element)
            } ?: sb.append("null")
            return sb.toString()
        }
    }

    private fun node(index: Int): Node<E>? {
        checkRange(index)
        var node = firstNode
        //这个地方要用until 最后一项不在范围内
        for (i in 0 until index) {
            node = node?.next
        }
        return node
    }

    override fun add(index: Int, element: E?) {
        if (index == 0) {
            //当插入第一项时 与其他项不太一样
            firstNode = Node(element, firstNode)
        } else {
            //和添加一样 要先定位到index前面一位的node
            val prev = node(index - 1)
            val next = prev?.next
            prev?.next = Node(element, next)
        }
        size++
    }

    override fun remove(index: Int): E? {
        var node = firstNode
        if (index == 0) {
            firstNode = firstNode?.next
        } else {
            val prev = node(index - 1)
            node = prev?.next
            prev?.next = node?.next
        }
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

fun main() {
    val list = SampleLinkedList<Int>()
    list.add(20)
    list.add(0, 10)
    list.add(30)
    list.add(list.size(), 40)

    list.remove(1)
    println(list)
}