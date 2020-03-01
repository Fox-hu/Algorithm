package com.fox.algorithm.dataStructure.tree

import com.fox.algorithm.dataStructure.tree.printer.BinaryTreeInfo
import com.fox.algorithm.dataStructure.tree.printer.BinaryTrees


/**
 * @Author fox
 * @Date 2020/2/25 15:00
 */
class BinarySearchTree<E : Comparable<E>> : BinaryTreeInfo {

    private class Node<E>(var element: E, var parent: Node<E>?) {
        var left: Node<E>? = null
        var right: Node<E>? = null
    }

    private var root: Node<E>? = null

    var size = 0

    fun size() = size

    fun isEmpty() = size == 0

    fun clear() {

    }

    fun add(element: E) {
        //添加的第一个节点
        if (root == null) {
            root = Node(element, null)
            size++
            return
        }

        var node = root
        var parent = root
        var cmp = 0
        while (node != null) {
            cmp = element.compareTo(node.element)
            parent = node
            node = when {
                cmp > 0 -> node.right
                cmp < 0 -> node.left
                else -> {
                    //替换是有必要的 如果是复杂对象的话 可能有cmp相等但其他属性变化的情况
                    node.element = element
                    return
                }
            }
        }

        val newNode = Node(element, parent)
        if (cmp > 0) {
            parent!!.right = newNode
        } else {
            parent!!.left = newNode
        }
        size++
    }

    fun remove(element: E) {

    }

    fun contains(element: E): Boolean {
        return false
    }

    override fun root(): Any? {
        return root
    }

    override fun left(node: Any?): Any? {
        return (node as Node<*>).left
    }

    override fun right(node: Any?): Any? {
        return (node as Node<*>).right
    }

    override fun string(node: Any?): Any? {
        return (node as Node<*>).element.toString() + "_${node.parent?.element.toString()}"
    }
}

fun main() {
    val intArrayOf = intArrayOf(7, 4, 9, 2, 5, 8, 11, 3)
    val bst = BinarySearchTree<Int>()
    intArrayOf.forEach { bst.add(it) }
    BinaryTrees.println(bst)
}