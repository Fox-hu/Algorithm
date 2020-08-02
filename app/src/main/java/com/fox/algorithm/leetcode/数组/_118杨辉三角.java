package com.fox.algorithm.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fox.hu
 * @date 2018/8/28
 */
//在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//示例:
//输入: 5
//输出:
//       [1],
//      [1,1],
//     [1,2,1],
//    [1,3,3,1],
//   [1,4,6,4,1]


public class _118杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            //第一行和第二行特殊 为1
            if (i == 0) {
                row.add(1);
            } else if (i == 1) {
                row.add(1);
                row.add(1);
            } else {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        //此处注意 是i-1
                        List<Integer> uperList = ret.get(i - 1);
                        row.add(uperList.get(j - 1) + uperList.get(j));
                    }
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
