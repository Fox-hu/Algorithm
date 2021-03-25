package com.fox.algorithm.数据结构与算法.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Fox
 * @Date 2021/3/25 11:01
 */
/*https://leetcode-cn.com/problems/subsets/
给你一个整数数组 nums ，数组中的元素 互不相同 。
返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：
输入：nums = [0]
输出：[[],[0]]
 */

/* 标准回溯框架
result=[]
def backtrack(路径，选择列表)：
if 满足结束条件：
    result.add(路径) #路径为temp数组
    return
for 选择 in 选择列表：
   做选择
   backtrack(路径，路径列表）
   撤销选择
 */

class _78子集 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTack(0, nums, res, new ArrayList<>());
        return res;
    }

    private void backTack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> integers) {
        res.add(new ArrayList<>(integers));
        for (int j = i; j < nums.length; j++) {
            integers.add(nums[j]);
            backTack(j + 1, nums, res, integers);
            integers.remove(integers.size() - 1);
        }
    }
}
