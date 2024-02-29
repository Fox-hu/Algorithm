//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1711 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //使用递减栈 栈中存index 栈中存index 栈中存index
    //当入栈时 保证栈是一个递减栈(小于栈顶直接入栈 大于栈顶则弹出栈内元素 至自己最小为止入栈)
    //在这个过程中,每次出栈的索引相减,就是该索引对应的结果值
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        //注意 这里stack存的是索引
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            //根据索引比较数组内容的大小
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer top = stack.pop();
                //将索引差值写入结果 这里是索引
                res[top] = i - top;
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
