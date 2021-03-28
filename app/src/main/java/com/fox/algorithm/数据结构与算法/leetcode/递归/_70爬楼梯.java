package com.fox.algorithm.数据结构与算法.leetcode.递归;

/**
 * @Author Fox
 * @Date 2021/3/28 12:28
 */

/*https://leetcode-cn.com/problems/climbing-stairs/
楼梯有n阶台阶，上楼可以走1阶，也可以一步上2阶，走完n阶台阶共有多少中不同的走法？
 */

class _70爬楼梯 {

    //使用递归的方式进行
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);

    }
    //滚动数组进行优化
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

}
