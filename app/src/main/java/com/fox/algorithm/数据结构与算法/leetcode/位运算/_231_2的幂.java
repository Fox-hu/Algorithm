package com.fox.algorithm.数据结构与算法.leetcode.位运算;

/**
 * @Author Fox
 * @Date 2021/3/27 11:05
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
