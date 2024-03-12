//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2237 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        //先将数组根据左端进行排序
        //第一个数组可以直接放入ret中 随后循环比较数组
        //如果当前区间的起始值 大于 ret数组中最后一个区间的结束值 说明不存在重叠 直接将当前区间添加到ret中 并递增index
        //反之则说明存在重叠 更新ret最后区间的和当前遍历区间右端的较大值
        //最后要再进行一次copy 因为ret最后可能会有空数组 需要排除
        int[][] ret = new int[intervals.length][2];
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int index = -1;
        for (int[] array : intervals) {
            if (index == -1 || array[0] > ret[index][1]) {
                //这里是++index 放入下一个位置
                ret[++index] = array;
            } else {
                //这里要比较两数组右侧的较大值 如[1,6],[2,5] ->[1,6]
                ret[index][1] = Math.max(ret[index][1], array[1]);
            }
        }
        //这里是index+1 试想只有一个数组时 也是要复制长度为1的
        return Arrays.copyOf(ret, index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
