package com.fox.algorithm.程序员面试金典._04树与图

/**
 * @Author fox.hu
 * @Date 2020/11/26 14:32
 */
/*链接：https://leetcode-cn.com/problems/check-subtree-lcci
检查子树。
有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为  T1 的子树。
如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
示例1:                                        示例2:
输入：t1 = [1, 2, 3], t2 = [2]                输入：t1 = [1, null, 2, 4], t2 = [3, 2]
输出：true                                    输出：false

提示 树的节点数目范围为[0, 20000]。*/


/*相同的树的进化版本 采用双重递归
判断t2是否为t1的子树，如果根节点相同，那么有必要开始判断从这个根节点开始这两棵树是否相同。
若相同了，说明已经找到，结束算法；如果不同，继续从t1的左右子树寻找t2，只要在一边找到就可以了。
根节点相同但仍然是不同的树，如 t1 = [2,2,3], t2 = [2]
如果根节点不相同，那么继续从t1的左右子树寻找t2，只要在一边找到就可以了
递归出口：空树认为是任何树的子树；当t1为空而t2不为空时，说明t1不包含t2。*/

fun checkSubTree(t1: TreeNode?, t2: TreeNode?): Boolean {
    //空树是所有树的字树
    if (t2 == null) return true
    //t1如果是空树则返回false
    if (t1 == null) return false

    //如果t1的根节点和t2根节点相等且左右子树一致 就返回true
    if (t1.`val` == t2.`val`) {
        if (isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right)) {
            return true
        }
    }

    //t1的根节点和t2根节点不相同 递归的从t1的左子树和右子树中寻找
    return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2)
}

private fun isSameTree(t1: TreeNode?, t2: TreeNode?): Boolean {
    //如果t1 t2都为空则返回true
    if (t1 == null && t2 == null) return true
    //走到下面时 t1 t2不会同时为空 当其中一个为空时则返回false
    if (t1 == null || t2 == null) return false
    //当节点不相等时返回false
    if (t1.`val` != t2.`val`) return false
    //递归两个树的子树
    return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right)
}
