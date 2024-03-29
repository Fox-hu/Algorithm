//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
//
// Related Topics 哈希表 链表 双指针 👍 2468 👎 0

package com.fox.algorithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    //使用快慢指针和两次循环 fast一次两步子 slow一次一步
    //在第一次循环中 确定是否有环以及相遇的节点
    //设链表共有a+b个节点，其中 链表头部到链表入口 有a个节点（不计链表入口节点）， 链表环 有b个节点
    //f=2s （快指针每次2步，路程刚好2倍）,f =s+nb (相遇时，刚好多走了n圈） 推出：s = nb
    //从head结点走到入环点需要走 ： a + nb， 而slow已经走了nb，那么slow再走a步就是入环点了。
    //如何知道slow刚好走了a步？ 我们将fast从head开始，和slow指针一起 每次走1步，相遇时刚好就是a步

    public ListNode detectCycle(ListNode head) {
        //这里的fast和slow都是从head开始的 和上一题不一样 fast不是从head.next开始的
        ListNode fast = head;
        ListNode slow = head;
        //这个循环既要判断是否有环 又要找到相遇的节点 内部有程序退出条件以及成环的条件
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        //上一个循环已经判断了是否有环 这里不会是死循环
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
