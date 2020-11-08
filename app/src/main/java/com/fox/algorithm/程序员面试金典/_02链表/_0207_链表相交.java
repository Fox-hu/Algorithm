package com.fox.algorithm.程序员面试金典._02链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Fox
 * @Date 2020/11/8 19:28
 */
//链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci
//给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
//示例 1：
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//示例 2：
//输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//示例 3：
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//注意：
//如果两个链表没有交点，返回 null 。
//在返回结果后，两个链表仍须保持原有的结构。
//可假定整个链表结构中没有循环。
//程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
class _0207_链表相交 {

    // 题设中 相交是基于节点的引用 而不是节点的值
    // 1.利用set来辅助 如果两个链表相交 则hashset中的引用是相同的
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.getNext();
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.getNext();
        }
        return null;
    }


    //2.利用双指针来解决
    //思路在于 用两个指针 同时从a b的起始位置开始 记为a1 b1，当a1走完a链表后再将其移到b，当b1走完b后将其移到a,
    // 走完a+b的长度后 如果a b相交 则最终两个指针会汇聚到交点处 如果不相交 则返回各自的最后一个
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            //如果指针tempA不为空，tempA就往后移一步。
            //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
            tempA = tempA == null ? headB : tempA.getNext();
            tempB = tempB == null ? headA : tempB.getNext();
        }
        //tempA要么是空，要么是两链表的交点
        return tempA;
    }
}
