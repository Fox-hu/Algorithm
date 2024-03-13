//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3442 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

package com.fox.algorithm.leetcode.editor.cn;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    //使用迭代。当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，
    //当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
    //当一个链表被添加完后 直接将另一个链表的剩余部分全部添加过去
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode head = preHead;
        //这里的&& 是因为只要有一个链表为空，就不需要再比较了
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                preHead.next = list2;
                list2 = list2.next;
            } else {
                preHead.next = list1;
                list1 = list1.next;
            }
            preHead = preHead.next;
        }
        preHead.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
