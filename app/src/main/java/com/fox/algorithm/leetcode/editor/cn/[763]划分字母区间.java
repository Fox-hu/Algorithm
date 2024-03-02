//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。 
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1103 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //可以分为如下两步：
    //统计每一个字符最后出现的位置
    //从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        //记录每个字符的最后出现位置
        int[] edges = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edges[chars[i] - 'a'] = i;
        }

        int index = 0; //用于记录 第0字符到当前字符 最后出现的位置
        int last = -1; //用于记录上次分隔的位置 用-1可以后面不用再-1了
        for (int i = 0; i < chars.length; i++) {
            //这里的意思说 比如abbabb a最后在第四位出现 但是b是在第六位出现
            //所以判断的时机要延后到第六位
            index = Math.max(index, edges[chars[i] - 'a']);
            if (i == index) {
                res.add(i - last);
                last = i;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
