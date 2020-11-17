package com.fox.algorithm.程序员面试金典._04树与图;

import com.fox.algorithm.程序员面试金典._02链表.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Fox
 * @Date 2020/11/16 21:59
 */
//链接：https://leetcode-cn.com/problems/list-of-depth-lcci
//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//示例：
//
//输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
class _0403_特定深度节点链表 {

    //采用层序遍历的变种
    //每次遍历一层 都将这层元素的左右元素放入待遍历的队列中
    public ListNode[] listOfDepth(TreeNode tree) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode curr = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                curr.setNext(new ListNode(treeNode.getVal()));
                if (treeNode.getLeft() != null) {
                    queue.offer(treeNode.getLeft());
                }
                if (treeNode.getRight() != null) {
                    queue.offer(treeNode.getRight());
                }
                curr = curr.getNext();
            }
            res.add(dummy.getNext());
            dummy.setNext(null);
        }

        return res.toArray(new ListNode[]{});
    }
}
