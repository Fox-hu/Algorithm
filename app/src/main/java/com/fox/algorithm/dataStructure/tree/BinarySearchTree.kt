package com.fox.algorithm.dataStructure.tree

import com.fox.algorithm.dataStructure.tree.printer.BinaryTreeInfo
import com.fox.algorithm.dataStructure.tree.printer.BinaryTrees


/**
 * @Author fox
 * @Date 2020/2/25 15:00
 */
class BinarySearchTree<E : Comparable<E>> : BinaryTreeInfo {

    class Node<E>(var element: E, var parent: Node<E>?) {
        var left: Node<E>? = null
        var right: Node<E>? = null

        fun hasTwoChildren() = left != null && right != null
    }

    private var root: Node<E>? = null

    var size = 0

    fun size() = size

    fun isEmpty() = size == 0

    fun clear() {
        root = null
        size = 0
    }

    fun contains(element: E): Boolean {
        return false
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
        remove(node(element))
    }

    private fun remove(node: Node<E>?) {
        var item: Node<E>? = node ?: return
        size--
        item?.let {
            if (it.hasTwoChildren()) { // 度为2的节点 // 找到后继节点
                val s = successor(it)
                // 用后继节点的值覆盖度为2的节点的值
                it.element = s!!.element
                // 删除后继节点
                item = s
            }
            // 删除it节点（it的度必然是1或者0）
            val replacement = if (it.left != null) it.left else it.right
            if (replacement != null) { // it是度为1的节点
                // 更改parent
                replacement.parent = it.parent
                // 更改parent的left、right的指向
                if (it.parent == null) { // it是度为1的节点并且是根节点
                    root = replacement
                } else if (it === it.parent!!.left) {
                    it.parent!!.left = replacement
                } else { // it == it.parent.right
                    it.parent!!.right = replacement
                }
            } else if (it.parent == null) { // it是叶子节点并且是根节点
                root = null
            } else { // it是叶子节点，但不是根节点
                if (it === it.parent!!.left) {
                    it.parent!!.left = null
                } else { // it == it.parent.right
                    it.parent!!.right = null
                }
            }
        }
    }


    //找到节点的前驱节点
    private fun predesessor(node: Node<E>?): Node<E>? {
        if (node == null) return null
        var node = node.left
        //左子树不为空的情况下 前驱节点就是左子树的最右边节点
        if (node != null) {
            while (node?.right != null) {
                node = node.right
            }
            return node
        }
        //左子树为空的情况下 从父节点、祖父节点中寻找前驱节点
        while (node?.parent != null && node == node.parent?.left) {
            node = node.parent
        }
        return node?.parent
    }

    //找到节点的后继节点
    private fun successor(node: Node<E>?): Node<E>? {
        if (node == null) return null
        var node = node.right
        //左子树不为空的情况下 前驱节点就是左子树的最右边节点
        if (node != null) {
            while (node?.left != null) {
                node = node.left
            }
            return node
        }
        //左子树为空的情况下 从父节点、祖父节点中寻找前驱节点
        while (node?.parent != null && node == node.parent?.right) {
            node = node.parent
        }
        return node?.parent
    }

    private fun node(element: E): Node<E>? {
        var node = root
        while (node != null) {
            val temp = node.element.compareTo(element)
            if (temp == 0) {
                return node
            } else if (temp > 0) {
                node = node.left
            } else {
                node = node.right
            }
        }
        return null
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

    //二叉树的高度
    fun height(node: Node<E>? = root): Int {
        if (node == null) {
            return 0
        }
        return 1 + Math.max(height(node.left), (height(node.right)))
    }
}

fun main() {
    val intArrayOf = intArrayOf(7, 4, 9, 2, 5, 8, 11, 3)
    val bst = BinarySearchTree<Int>()
    intArrayOf.forEach { bst.add(it) }
    bst.remove(5)
    BinaryTrees.println(bst)
//    println(bst.height())
}