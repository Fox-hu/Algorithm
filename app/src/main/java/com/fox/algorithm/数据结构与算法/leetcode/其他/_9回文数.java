package com.fox.algorithm.数据结构与算法.leetcode.其他;

/**
 * @Author Fox
 * @Date 2021/3/28 13:02
 */
/*https://leetcode-cn.com/problems/palindrome-number/
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。*/

    /*
    反转 int 数字的一半,如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同
     */
class _9回文数 {

    public boolean isPalindrome(int x) {
        //当x为10的倍数且x不为0时，或x为负数时 不可能为回文数
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        int revertedNumber = 0;
        while (revertedNumber < x) {
            revertedNumber = 10 * revertedNumber + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
