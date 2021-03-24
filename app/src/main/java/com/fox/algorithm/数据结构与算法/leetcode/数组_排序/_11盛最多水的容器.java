package com.fox.algorithm.数据结构与算法.leetcode.数组_排序;

/**
 * @Author Fox
 * @Date 2021/3/21 15:02
 */
/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49
 */

/*
 设置双指针 l,r分别位于容器壁两端，根据规则移动指针
 如果是l的长度小于r的长度则l++ 否则r--
 并且更新面积最大值 res，直到  r == l时返回 res
 */
class _11盛最多水的容器 {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0;
        while (l < r) {
            res = height[l] < height[r]
                  ? Math.max(res, (r - l) * height[l++])
                  : Math.max(res, (r - l) * height[r--]);
        }
        return res;
    }
}
