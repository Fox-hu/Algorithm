package com.fox.algorithm.数据结构与算法.leetcode.回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Fox
 * @Date 2021/3/21 15:26
 */

/*https://leetcode-cn.com/problems/permutations/
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/

/*
回溯算法
 */
class _46全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            //动态维护数组
            Collections.swap(output, first, i);
            //继续递归下一个数字
            backtrack(n, output, res, first + 1);
            //撤销操作
            Collections.swap(output, first, i);
        }
    }
}
