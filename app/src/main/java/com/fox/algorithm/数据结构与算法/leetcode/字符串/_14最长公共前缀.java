package com.fox.algorithm.数据结构与算法.leetcode.字符串;

/**
 * @Author Fox
 * @Date 2021/3/28 14:01
 */
class _14最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix == null || prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String start, String end) {
        int limit = Math.min(start.length(), end.length());
        int index = 0;
        while (index < limit && start.charAt(index) == end.charAt(index)) {
            index++;
        }
        return start.substring(0, index);
    }
}
