//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3521 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", n, n);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     */
    private void backtrack(String curStr, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        //剪枝 右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支
        if(left > right) return;
        if (left > 0) {
            //利用java中string的特性 无需增加和恢复
            backtrack(curStr+"(", left - 1, right);
        }
        if (right > 0) {
            backtrack(curStr+")", left, right - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
