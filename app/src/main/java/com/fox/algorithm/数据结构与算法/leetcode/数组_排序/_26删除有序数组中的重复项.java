package com.fox.algorithm.数据结构与算法.leetcode.数组_排序;

/**
 * @Author Fox
 * @Date 2021/3/29 10:10
 */

/*https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
示例 1:
给定数组 nums = [1,1,2],
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
你不需要考虑数组中超出新长度后面的元素。

使用双指针 思路在于 重复的项目跳快指针，不重复时将值赋值给慢指针+1 可以做到两点 1、跳重复、2、重新赋值给重复项
数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j是快指针。只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。
当我们遇到 nums[j] !=nums[i] 时，跳过重复项的运行已经结束，
因此我们必须把它 nums[j]的值复制到 nums[i+1]。然后递增 i，接着我们将再次重复相同的过程，直到 j到达数组的末尾为止。*/

class _26删除有序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int slow = 0;
        for(int fast = 1;fast<nums.length;fast++ ){
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
