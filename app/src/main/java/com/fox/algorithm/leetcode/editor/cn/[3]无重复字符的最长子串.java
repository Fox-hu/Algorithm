//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9975 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //移动窗口
        //使用map记录char和index的信息
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 1;
        int left = 0;
        //当map中没有char时 left不用移动 长度自然增长1
        //当map中有该char时 说明之前出现过该char 那么将该char的index+1 移出窗口 left也随之移动
        //更新char和index的记录
        //循环完成 得出最大长度
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
        //如果当前字符 ch 包含在 map中，此时有2类情况：
        //1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
        //那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
        //2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
        //而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
        //随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
        //应该不变，left始终为2，子段变成 ba才对。
        //
        //为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
        //    另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
        //因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
