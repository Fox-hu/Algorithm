package com.fox.algorithm.程序员面试金典

/**
 * @Author Fox
 * @Date 2020/10/28 21:23
 */

//链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
//不占用额外内存空间能否做到？
//示例 1:
//给定 matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//示例 2:
//给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
class _0107_旋转矩阵 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val size = matrix.size
        //1.首先以对角线为轴进行反转
        //以对角线反转 只需要遍历一个矩形的斜对角区域即可 同时也不需要遍历最后一行的内容
        for (i in 0 until size - 1) {
            for (j in i + 1 until size) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        //2.再对每一行以中点进行反转
        //对每一行以中心进行反转 只需要遍历到每一行的中点为止 因为一个点和对应的反转点和为size-1
        val mid = size / 2
        for (i in 0 until size) {
            for (j in 0 until mid) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][size - 1 - j]
                matrix[i][size - 1 - j] = temp
            }
        }
    }
}