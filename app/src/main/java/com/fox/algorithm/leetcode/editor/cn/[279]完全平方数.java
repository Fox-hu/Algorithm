//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1921 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //动态规划 dp[i]表示第i个数组 最少由多少个平方数组成
    //那么dp[i]最大应该为i 即当全部由1组成 我们假设j是由1递增
    //那么dp[i]的状态方程可以得出 dp[i] = min(dp[i],dp[i-j*j]+1);
    //可以看出 这里的dp[i]并不是由dp[i-1]推导
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            //最差的情况就全部是1组成 这句话要放到外循环 由内循环不断刷新最小值
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                //比如 12 就是 12-1 12-4 12-9中的最小值 +1
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
