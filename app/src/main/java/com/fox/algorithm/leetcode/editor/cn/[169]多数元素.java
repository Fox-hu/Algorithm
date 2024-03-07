//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2148 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //map中k是数字 v是出现的次数 每次遍历记录最大值
    //(剪枝) 当value > nums.length/2时 找到目标了 直接返回
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, maxTimes = 0;
        for (int num : nums) {
            Integer times = map.getOrDefault(num, 0) + 1;
            if (times > nums.length / 2) {
                return num;
            }
            map.put(num, times);
            if (times > maxTimes) {
                maxTimes = times;
                max = num;
            }
        }
        return max;
    }

    //解2 由题意可得 多数元素是>n/2的 那么可以得出
    //将数组排序后 取nums[n/2]的元素就是要找的目标元素
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length/2];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
