package com.fox.algorithm.数据结构与算法.leetcode.数组_排序;

/**
 * @Author Fox
 * @Date 2021/3/21 16:07
 */
/*
整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：
输入：nums = [1], target = 0
输出：-1
*/

/*
二分法确定所在区域后进行范围缩小
 */

class _33搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            //经过旋转后的数组 要么左边有序 要么右边有序 如果nums[0]<nums[mid] 则一定是左侧有序
            if (nums[0] <= nums[mid]) {
                //左侧有序 注意左闭右开
                if (nums[0] <= target && target < nums[mid]) {
                    //在左边
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //右侧有序 注意左开右闭
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
