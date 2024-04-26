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
        int[][] ret = new int[intervals.length][2];
        Arrays.sort(intervals,(v1,v2)-> v1[0]-v2[0]);
        int index = -1;
        for(int[] intArray:intervals){
            if(index == -1 || intArray[0] > ret[index][1]){
                ret[++index] = intArray;
            }else{
                ret[index][1] = Math.max(intArray[1],ret[index][1]);
            }
        }
        return Arrays.copyOf(ret,index+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
