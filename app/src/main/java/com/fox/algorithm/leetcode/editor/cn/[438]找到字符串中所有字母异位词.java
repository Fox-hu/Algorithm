//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1382 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //用int数组标记该字符串内字符出现的频次
        //使用滑动窗口进行滑动 注意 这个窗口的大小是p.length
        //如果代表频次的数组一致 那么他们就是异位词
        List<Integer> ret = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        if (slen < plen) {
            return ret;
        }
        int[] scount = new int[26];
        int[] pcount = new int[26];
        for (int i = 0; i < plen; i++) {
            scount[s.charAt(i) - 'a'] += 1;
            pcount[p.charAt(i) - 'a'] += 1;
        }
        //首次一致 要特殊处理
        if (Arrays.equals(pcount, scount)) {
            ret.add(0);
        }

        for (int i = 0; i < slen - plen; i++) {
            //滑动窗口 将窗口左侧移出 因为之前已经做过判断了
            scount[s.charAt(i) - 'a'] -= 1;
            //滑动窗口 将右边下一位的字符移入窗口
            scount[s.charAt(i+plen)-'a'] +=1;

            if(Arrays.equals(pcount,scount)){
                //循环从0开始 所以这里是i+1
                //如abab和ab ab是ab的异位词 然后去掉第一个a 添加第二个a 变成了ba 这里的索引就是1
                ret.add(i+1);
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
