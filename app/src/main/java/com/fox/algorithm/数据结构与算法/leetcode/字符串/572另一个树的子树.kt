package com.fox.algorithm.数据结构与算法.leetcode.字符串

import com.fox.algorithm.数据结构与算法.leetcode.二叉树.TreeNode
import com.fox.algorithm.数据结构与算法.数据结构.树.printer.BinaryTreeInfo
import com.fox.algorithm.数据结构与算法.数据结构.树.printer.BinaryTrees

/**
 * @Author fox.hu
 * @Date 2021/2/19 10:40
 */
/*https://leetcode-cn.com/problems/subtree-of-another-tree
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
示例 1:
给定的树 s:
3
/ \
4   5
/ \
1   2
给定的树 t：
4
/ \
1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：
3
/ \
4   5
/ \
1   2
/
0
给定的树 t：
4
/ \
1   2
返回 false。
*/

//使用字符串来表示一个树 将树用后序遍历进行序列化 空节点用#!表示，节点n用n!表示
//如果t是s的子树，则s序列化后字符串会包含t序列化后的字符串
fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
    return s != null && t != null && postSerialize(s).contains(postSerialize(t))
}

/**
 * 采用后序遍历来构建字符串
 */
private fun postSerialize(node: TreeNode): String {
    val sb = StringBuilder()
    postSerialize(node, sb)
    return sb.toString()
}

private fun postSerialize(node: TreeNode, sb: StringBuilder): String {
    if (node.left == null) {
        sb.append("#!")
    } else {
        postSerialize(node.left!!, sb)
    }

    if (node.right == null) {
        sb.append("#!")
    } else {
        postSerialize(node.right!!, sb)
    }
    sb.append("${node.`val`}!")
    return sb.toString()
}

fun main() {
    val root = TreeNode(3).apply {
        right = TreeNode(5)
        left = TreeNode(4)
        left!!.left = TreeNode(1)
        left!!.right = TreeNode(2)
    }

    BinaryTrees.println(object : BinaryTreeInfo {
        override fun root(): Any {
            return root
        }

        override fun right(node: Any?): TreeNode? {
            return (node as TreeNode).right
        }

        override fun left(node: Any?): TreeNode? {
            return (node as TreeNode).left
        }

        override fun string(node: Any?): Any {
            return (node as TreeNode).`val`
        }

    })

    println(postSerialize(root))
}