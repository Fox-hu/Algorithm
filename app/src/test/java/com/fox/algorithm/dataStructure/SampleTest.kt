package com.fox.algorithm.dataStructure

import com.fox.algorithm.dataStructure.list.SampleAbstractList
import com.fox.algorithm.dataStructure.list.SampleArrayList
import com.fox.algorithm.dataStructure.queue.SampleCircleQueue
import com.fox.algorithm.dataStructure.stack.SampleStack
import org.junit.Test

/**
 * @Author fox
 * @Date 2020/2/20 19:25
 */
class SampleTest {


    @Test
    fun testList() {
//        val list = SampleLinkedList<Int>()
        val list = SampleArrayList<Int>()
        list.add(11)
        println(list)
        list.add(22)
        println(list)
        list.add(33)
        println(list)
        list.add(44)
        println(list)
        list.add(0, 55)
        println(list)
        list.add(2, 66)
        println(list)
        list.add(list.size(), 77)
        println(list)

        list.remove(0)
        println(list)
        list.remove(2)
        println(list)
        list.remove(list.size() - 1)
        println(list)

        assert(list.indexOf(44) == 3)
        assert(list.indexOf(22) == SampleAbstractList.DEFAULT_ELEMENT_NOT_FOUND)
        assert(list.contains(33))
        assert(list.get(0) == 11)
        assert(list.get(1) == 66)
        assert(list.get(list.size() - 1) == 44)
    }

    @Test
    fun testStack() {
        val stack = SampleStack<Int>()
        stack.push(11)
        stack.push(22)
        stack.push(33)
        stack.push(44)

        stack.pop()

        stack.top()

        println(stack)
    }

    @Test
    fun testQueue() {
        val queue = SampleCircleQueue<Int>()
        for (i in 0 until 10) {
            queue.enQueue(i)
        }
        for (i in 0 until 5) {
            queue.deQueue()
        }
        println(queue)
        for (i in 15 until 23) {
            queue.enQueue(i)
        }
        println(queue)
    }
}