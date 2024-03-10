//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 1976 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        //1.使用set 过滤掉重复数据
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        //遍历nums，对于当前num 如果set中没有num-1 那么长度就应该重置为1
        //如果set中有num+1 那么继续去找num+2\3...n 找到最长长度
        //更新循环的最大长度 遍历结束时 即可得出最大长度
        for (Integer num : set) {
            //如果一个数num在集合中，而num-1也在集合中，那么num就不是连续序列的起始点
            //所以这里只检查 num在集合中，而num-1不在集合中的数字
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentSize = 1;
                //这里的currentNum每次遍历都会自增
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentSize += 1 ;
                }
                max = Math.max(max,currentSize);
            }
        }
        return max;
    }
}
        //leetcode submit region end(Prohibit modification and deletion)
