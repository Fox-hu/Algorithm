//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7093 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //dp[i][j]表示的是s[i,j]是否为回文串,存储为true、false
    //故dp的值可以分两种情况求出
    //- j-i+1 <=2时 dp[i][j] = s[i]==s[j]
    //- .当j-i+1 >2时 dp[i][j] = dp[i+1][j-1] && s[i] == s[j]

    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int len = s.length(), max = 1, left = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        //遍历时 j < i时无意义 遍历的顺序应该是从由下往上 由左往右遍历
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                int dis = j - i + 1;
                if (dis <= 2) {
                    dp[i][j] = ch[i] == ch[j];
                } else {
                    dp[i][j] = dp[i+1][j-1] && ch[i] == ch[j];
                }
                //是回文子串 并且长度是目前最长的 更新左边界和长度的值
                if(dp[i][j] && dis > max){
                    max = dis;
                    left = i;
                }
            }
        }
        return new String(ch,left,max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
