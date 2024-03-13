//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2241 👎 0
package com.fox.algorithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    //偷懒解法 将链表转为数组 排序后重新构造链表
    public ListNode sortList(ListNode head) {
        //这里不能用arraylist 没办法排序
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);
        ListNode cur = head;
        int length = getListNodeSize(cur);
        int[] arrays = new int[length];
        for (int i = 0; i < length; i++) {
            arrays[i] = cur.val;
            cur = cur.next;
        }
        Arrays.sort(arrays);
        cur = head;
        for (int i = 0; i < length; i++) {
            cur.val = arrays[i];
            cur = cur.next;
        }
        return head;
    }

    public int getListNodeSize(ListNode cur) {
        int length = 0;
        ListNode head = cur;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
