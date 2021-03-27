package com.fox.algorithm.数据结构与算法.leetcode.字符串;

/**
 * @Author Fox
 * @Date 2021/3/27 10:15
 */

/*https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例：
输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"
 */

/*
当遇到空格字符，就需要对刚刚遍历过的单词进行反转操作，此单词的右索引是 i - 1，定义一个int变量start，用来记录单词的左索引；
利用字符数组前后交换字符位置的方法进行反转操作；反转结束后，把start索引置为 i + 1，指向下一个单词的开头；
遍历继续，直到遇到下一个空格字符或结尾；
到了字符数组结尾，那么最后一个单词的开头和结束索引分别是 start 和 n - 1，利用这两个索引进行单词翻转；
 */
class _557反转字符串中的单词III {

    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int start = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                reverse(ch, start, i-1);
                start = i + 1;
                continue;
            }
            if (i == ch.length - 1) {
                reverse(ch, start, i);
            }
        }
        return new String(ch);
    }

    private void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

}
