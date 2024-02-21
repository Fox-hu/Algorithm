//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics 数组 前缀和 👍 1712 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //原数组：       [1       2      3       4]
    //左部分的乘积：   1       1      1*2    1*2*3
    //右部分的乘积：  2*3*4    3*4     4       1
    //结果：       1*2*3*4  1*3*4   1*2*4  1*2*3*1
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        //ret[n]此时代表的是第n个数的乘积是多少
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            //左边的乘积计算
            ret[i] = nums[i - 1] * ret[i - 1];
        }
        int temp = 1;
        for (int k = nums.length - 2; k >= 0; k--) {
            temp = temp * nums[k + 1];
            //此时的ret乘以右边的乘积 即为左右部分相乘 所求的结果
            ret[k] = temp * ret[k];
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
