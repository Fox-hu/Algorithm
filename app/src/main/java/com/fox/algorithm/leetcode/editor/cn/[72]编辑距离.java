//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3310 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        //动态规划 dp[i][j] 代表 从text1[0-i]与text2[0-j]的最小步数
        //转移方程 当text1[i-1] = text2[j-1]时 dp[i][j] = dp[i - 1][j - 1];
        //  否则 dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) +1;
        //其中 dp[i - 1][j - 1] 到dp[i][j]相当于 替换操作
        //其中 dp[i - 1][j] 到dp[i][j]相当于 增加操作
        //其中 dp[i][j - 1]) +1 到dp[i][j]相当于  删除操作

        //这个要怎么理解呢 因为dp[i][j]是text1[0-i]与text2[0-j]的最小步数
        //那么dp[i - 1][j - 1]计算得出后 text1[0-i-1]与text2[0-j-1]一定是一致的 那么只需要再替换最后一位不相同的数字就能达到目标 所以说是替换操作

        //初始化
        //第一行，是 word1 为空变成 word2 最少步数，就是插入操作
        //第一列，是 word2 为空，需要的最少步数，就是删除操作
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //遍历范围是[1,m],[1,n] 所以charAt的需要-1 否则溢出
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }


}
//leetcode submit region end(Prohibit modification and deletion)
