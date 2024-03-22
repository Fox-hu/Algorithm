//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2414 👎 0


import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 采用优先队列 默认是由小到大排序
        // 所以依次添加元素到队列中,当队列中超过k个后 弹出最上面的值 那么顶部的值就是第k个最大元素
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            //每次添加元素后，检查队列的大小是否超过了k。如果超过了k，就会移除队列头部的元素（也就是当前队列中最小的元素）。
            //这样，队列中始终保持着nums数组中的前k大的元素，且队列头部是这k个元素中最小的
            //[3,2,1,5,6,4] 最终queue中剩余的是[6.5]
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
