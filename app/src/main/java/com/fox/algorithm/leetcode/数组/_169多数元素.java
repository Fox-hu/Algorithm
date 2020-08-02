package com.fox.algorithm.leetcode.数组;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by fox.hu on 2018/8/30.
 */
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
// 
//
//示例 1:
//
//输入: [3,2,3]
//输出: 3
//示例 2:
//
//输入: [2,2,1,1,1,2,2]
//输出: 2

public class _169多数元素 {


    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Integer sum = 0;
        Integer index = 0;
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (map.get(integer) > sum) {
                sum = map.get(integer);
                index = integer;
            }
        }

        return index;
    }

    public int majorityElement_MooreVote(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                res = num;
                ++cnt;
            } else if (num == res) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return res;
    }
}
