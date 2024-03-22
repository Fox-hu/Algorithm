//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2630 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //两次查找
    //先找左边的界限 找到目标后 记录找到的值 然后将hi=mid-1 继续向左查找
    //再找右边的界限 找到目标后 记录找到的值 然后将lo=mid+1 继续向右查找
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums[nums.length - 1] < target || nums[0] > target) {
            return new int[]{-1, -1};
        }
        int lm = leftMargin(nums, target);
        int rm = rightMargin(nums, target);
        return new int[]{lm, rm};
    }

    private int leftMargin(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        int first = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                first = mid;
                //如果是普通二分法 就此结束 这里的意思是找到了左边界以后 继续向左边找 看看能不能找到同样的值
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return first;
    }

    private int rightMargin(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        int last = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                last = mid;
                //如果是普通二分法 就此结束 这里的意思是找到了右边界以后 继续向右边找 看看能不能找到同样的值
                lo = mid + 1;
                //注意这里是互斥的 找到target后就要进入下一个循环
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)