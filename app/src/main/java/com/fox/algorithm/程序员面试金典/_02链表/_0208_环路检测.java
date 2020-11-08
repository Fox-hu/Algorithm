package com.fox.algorithm.程序员面试金典._02链表;

/**
 * @Author Fox
 * @Date 2020/11/8 19:59
 */
//链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
//给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
//有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
//示例 1：
//输入：A->B->C->D->E->C
//输出：C

//进阶：
//你是否可以不用额外空间解决此题？
class _0208_环路检测 {

    //使用快慢指针
    //首先确定是否有环 其次确定环的起始点
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                //确定有环之后 将head和slow同时步进，则两个指针相等时就是环的起始点
                while (head != slow) {
                    head = head.getNext();
                    slow = slow.getNext();
                }
                return slow;
            }
        }
        return null;
    }
}
