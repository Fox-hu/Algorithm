package com.fox.algorithm.数据结构与算法.leetcode.位运算;

/**
 * @Author Fox
 * @Date 2021/3/27 11:05
 */
/*https://leetcode-cn.com/problems/power-of-two/
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
示例1:
输入: 1
输出: true
解释: 2^0= 1
示例 2:
输入: 16
输出: true
解释: 2^4= 16
示例 3:
输入: 218
输出: false
 */
class _231_2的幂 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
