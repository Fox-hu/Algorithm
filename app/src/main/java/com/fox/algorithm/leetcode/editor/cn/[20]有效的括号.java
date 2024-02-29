//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4354 👎 0


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //如果遇到左括号 就入栈
    //如果遇到右括号 弹出栈顶 两者对应 则抵消
    private final Map<Character, Character> pairs = new HashMap() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (pairs.containsKey(ch)) {
                //右侧括号
                if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
                    return false;
                }
            } else {
                //左侧括号
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
