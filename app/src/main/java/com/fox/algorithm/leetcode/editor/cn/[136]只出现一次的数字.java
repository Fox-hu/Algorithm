package com.fox.algorithm.leetcode.editor.cn;
/**
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 

 说明： 

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 

 示例 1: 

 输入: [2,2,1]
输出: 1
 

 示例 2: 

 输入: [4,1,2,1,2]
输出: 4 

 Related Topics 位运算 数组 👍 2561 👎 0

*/
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //使用亦或操作 亦或有以下3个性质
    //任何数和0做异或操作，结果仍然是原来的数，即x ^ 0 = x。
    //任何数和其自身做异或操作，结果是0，即x ^ x = 0。
    //异或操作满足交换律和结合律，即x ^ y = y ^ x和(x ^ y) ^ z = x ^ (y ^ z)。
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
