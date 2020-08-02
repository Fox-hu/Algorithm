package com.fox.algorithm.leetcode.数组;

/**
 * Created by fox.hu on 2018/8/30.
 */

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//示例:
//
//输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//说明:
//
//必须在原数组上操作，不能拷贝额外的数组。
//尽量减少操作次数。


public class _283移动零 {
    //要求是将0后移，实际上就是将非0前移
    //两个指针控制 一个遍历整改数组 一个记录非0项 然后将数组剩余项填充为0

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
