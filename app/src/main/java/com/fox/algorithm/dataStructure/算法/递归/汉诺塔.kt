package com.fox.algorithm.dataStructure.算法.递归

/**
 * @Author Fox
 * @Date 2020/11/30 20:40
 */
//编程实现把A的n个盘子移动到C 可以使用一个辅助B
//1 每次只能移动一个盘子
//2 大盘子只能放到小盘子下面
class 汉诺塔 {

    //递归的思路在于
    //先将n-1个盘子移动到p2,然后将n移动到p3 最后将n-1个盘子移动到p3
    fun hanoi(n: Int, p1: String, p2: String, p3: String) {
        if (n == 1) {
            move(n, p1, p3)
        }
        hanoi(n - 1, p1, p3, p2)
        move(n, p1, p3)
        hanoi(n - 1, p2, p1, p3)
    }

    /***
     * 将no号盘子从from移动到to
     */
    private fun move(n: Int, from: String, to: String) {
        println("将${n}号盘子从${from}移动到${to}")
    }
}