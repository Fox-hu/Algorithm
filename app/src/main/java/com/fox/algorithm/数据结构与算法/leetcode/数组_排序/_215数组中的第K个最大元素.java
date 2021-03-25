package com.fox.algorithm.数据结构与算法.leetcode.数组_排序;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author Fox
 * @Date 2021/3/25 10:39
 */
class _215数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> qpNums = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            qpNums.offer(nums[i]);
            if (qpNums.size() > k) {
                qpNums.poll();
            }
        }
        return qpNums.peek();
    }
}
