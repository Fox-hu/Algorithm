package com.fox.algorithm.leetcode.数组;

/**
 * Created by fox.hu on 2018/8/30.
 */

//给定一个二进制数组， 计算其中最大连续1的个数。
//
//示例 1:
//
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
//注意：
//
//输入的数组只包含 0 和1。
//输入数组的长度是正整数，且不超过 10,000。

public class _485最大连续1的个数 {
    //对每个元素进行判断 如果为1则计数器+1;
    //当为0时记录此次连续1的个数 然后清零，只记录最大的一项计数器值
    //当数组的最后一项为1时，此处cnt并未返回给max 固需要判断两者的最大值
    //比如[1,1,0,1,1,1]
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                if (cnt > max) {
                    max = cnt;
                }
                cnt = 0;
            }
        }

        return Math.max(cnt, max);
    }
}
