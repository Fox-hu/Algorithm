//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2189 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        //动态规划 dp[i]代表的是到第i位 最大的数组乘积
        //因为有负数的存在 导致最小变最大 最大变最小 需要同时记录最大值和最小值
        int imax = 1, imin = 1;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            //当num < 0 时 阶段最大和阶段最小值就要调换位置了
            if (num < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            imin = Math.min(imin * num, num);
            imax = Math.max(imax * num, num);
            //这里还是阶段最大和总最大比 imin只做记录最小值
            max = Math.max(imax, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
