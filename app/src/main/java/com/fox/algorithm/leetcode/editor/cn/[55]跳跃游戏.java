//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2676 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
    //可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
    //如果可以一直跳到最后，就成功了
    public boolean canJump(int[] nums) {
        //max 代表目前能跳跃到的最大距离
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 这行的意思是 能跳到的最大距离都够不到i 那说明跳不到i处 返回false
            if (i > max) return false;
            // 如果能跳到 更新max的大小 （i+num[i]代表i处起跳的最远距离）
            max = Math.max(max, i + nums[i]);
        }
        //如果中途没有退出 那么说明遍历到最后一个节点了 就是能够达到最后节点 返回true
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
