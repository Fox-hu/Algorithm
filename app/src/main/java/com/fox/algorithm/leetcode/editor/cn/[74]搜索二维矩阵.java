//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 901 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //将二维数组转为一维数组 hi值为m*n-1，在mid处的值 = matrix[mid / n][mid % n]
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //核心在于这句话 将二维的转为一维的 注意 横坐标是mid/n 纵坐标是mid%n
            int num = matrix[mid / n][mid % n];
            if (num == target) {
                return true;
            } else if (num < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
