package com.fox.algorithm.leetcode.数组;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fox.hu on 2018/8/30.
 */
//进阶：
//
//        你可以优化你的算法到 O(k) 空间复杂度吗？

public class _119杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        Integer[] integers = new Integer[rowIndex + 1];
        Arrays.fill(integers, 0);

        integers[0] = 1;
        for (int i = 1; i < integers.length; i++) {
            for (int j = i; j > 0; j--) {
                integers[j] = integers[j] + integers[j - 1];
            }
        }

        return Arrays.asList(integers);
    }
}
