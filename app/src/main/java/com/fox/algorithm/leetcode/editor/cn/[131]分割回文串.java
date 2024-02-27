//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1734 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    回溯模板
//    res = []
//    path = []
//
//    def backtrack(未探索区域, res, path):
//        if 未探索区域满足结束条件:
//           res.add(path) # 深度拷贝
//           return
//        for 选择 in 未探索区域当前可能的选择:
//            if 当前选择符合要求:
//              path.add(当前选择)
//              backtrack(新的未探索区域, res, path)
//              path.pop()

    int length;
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    char[] charArray;

    public List<List<String>> partition(String s) {
        charArray = s.toCharArray();
        length = s.length();
        backtrack(0);
        return res;
    }

    private void backtrack(int index) {
        if (index == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < length; i++) {
            //产生前缀字符串的时候，判断前缀字符串是否是回文。
            //如果前缀字符串是回文，则可以产生分支和结点；
            //如果前缀字符串不是回文，则不产生分支和结点，这一步是剪枝操作
            if (isPalindrome(index, i)) {
                path.add(new String(charArray, index, i - index + 1));
                backtrack(i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int start, int end) {
        while (start<end){
            if(charArray[start++]!=charArray[end--]){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
