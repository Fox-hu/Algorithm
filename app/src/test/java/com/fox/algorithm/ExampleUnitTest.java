package com.fox.algorithm;

import com.fox.algorithm.数据结构与算法.算法.回溯.八皇后;
import com.fox.algorithm.数据结构与算法.算法.贪心.最优装载;
import com.fox.algorithm.数据结构与算法.算法.贪心.背包问题;
import com.fox.algorithm.数据结构与算法.算法.贪心.零钱兑换;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void nQueens(){
        new 八皇后().placeQueens(8);
    }

    @Test
    public void greedy(){
        new 最优装载().getMaxNum();
    }

    @Test
    public void greedy1(){
        new 零钱兑换().coinChange(41);
    }

    @Test
    public void knapsackTest(){
        new 背包问题().knapsack();
    }
}