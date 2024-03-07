//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3 : 
//
// 
//输入：nums = [3,3,3,3,3]
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
//
// Related Topics 位运算 数组 双指针 二分查找 👍 2360 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        //数组的范围是n+1 如果没有重复的数字 那么一直进行nums[nums[index]] 最终会数组越界
        //如果数组中有重复的数 那么nums[nums[index]]将可以一直进行下去
        //可以将其类比为链表中有环 那么问题就可以被转换为 找到链表中环的入口
        //同问题142
        if (nums.length == 1) {
            return nums[0];
        }
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        //因为确定有环 那么这个不会死循环
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int pre1 = 0;
        int pre2 = slow;
        while (pre2 != pre1) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
