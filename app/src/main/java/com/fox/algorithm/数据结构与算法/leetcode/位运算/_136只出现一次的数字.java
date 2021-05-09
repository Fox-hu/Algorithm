package com.fox.algorithm.数据结构与算法.leetcode.位运算;

/**
 * @Author Fox
 * @Date 2021/3/29 10:13
 */
/*
https://leetcode-cn.com/problems/single-number/
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:
输入: [2,2,1]
输出: 1
示例2:
输入: [4,1,2,1,2]
输出: 4
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
