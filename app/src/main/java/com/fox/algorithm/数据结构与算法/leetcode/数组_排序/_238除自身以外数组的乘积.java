package com.fox.algorithm.数据结构与算法.leetcode.数组_排序;

/**
 * @Author Fox
 * @Date 2021/3/27 10:35
 */

/*
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

示例:
输入: [1,2,3,4]
输出: [24,12,8,6]
 */

/*
我们可以将 res 数组列成乘积形式，不同的 nn 组成每行内容，形成一个矩阵，
可以发现矩阵 主对角线 全部为 1 （当前数字不相乘，等价为乘 1）；
因此，我们分别计算矩阵的 下三角 和 上三角，并且在计算过程中储存过程值，最终可以在遍历 2遍 nums 下完成结果计算。
 */
class _238除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int j = nums.length - 1; j > 0; j--) {
            q *= nums[j];
            res[j - 1] *= q;
        }
        return res;
    }
}
