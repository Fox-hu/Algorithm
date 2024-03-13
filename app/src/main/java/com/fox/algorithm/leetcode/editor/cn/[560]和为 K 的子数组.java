//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2246 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        //key代表数组的累加和 value代表出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        //数字0出现1次 插入map中
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            //sum(j) - sum(i) = k 说明找到了
            if (map.containsKey(sum - k)) {
                //注意这里 加的是次数 如果前i个数的和为sum
                //那么如果能找到前j个数的和为sum-k的话(j<i) 那么sum-k出现的次数就是目标解中的子集
                //例如 [1,2,3,1,2,3] k=6 假设i = 5,num = 2,此时 sum = 9 那么sum - k = 3
                //map.get(sum - k) = 2 说明有两个路径可以到达 也就是[1,2]和[3] 分别和[1,2]组合可以得到k
                count += map.get(sum - k);
            }
            //记录本次的数字和次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
