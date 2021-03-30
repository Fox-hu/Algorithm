package com.fox.algorithm.数据结构与算法.leetcode.位运算;

/**
 * @Author Fox
 * @Date 2021/3/29 10:13
 */
class _136只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
