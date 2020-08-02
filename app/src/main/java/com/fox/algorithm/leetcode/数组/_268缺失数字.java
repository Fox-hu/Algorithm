package com.fox.algorithm.leetcode.数组;

/**
 * Created by fox.hu on 2018/8/31.
 */

//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//示例 1:
//
//输入: [3,0,1]
//输出: 2
//示例 2:
//
//输入: [9,6,4,2,3,5,7,0,1]
//输出: 8


public class _268缺失数字 {
    public int missingNumber(int[] nums) {
        //利用等差公式求和 再减去数组中所有的值，剩下的即为所缺值
        int n = nums.length + 1;
        int sum = n * (n - 1) / 2;

        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
