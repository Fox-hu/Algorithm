//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1793 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //使用map key是数字 value是出现的次数
        //使用优先队列 处理map中的数据 当队列数未到k时加入队列
        //当超过k个 更新优先级队列中的数 保持前k个最大值
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //这里传递的是一个比较器 每次remove时 就会remove 掉 map.get最小的值
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Integer key : map.keySet()) {
            //入队 如果数量超过k个 则进来一个就去掉一个 去掉出现频率最小的
            queue.add(key);
            if(queue.size()>k){
                queue.remove();
            }
        }
        int[] res = new int[queue.size()];
        //这里不能使用for循环 因为queue的数量会有变化
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.remove();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
