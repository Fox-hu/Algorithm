//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1620 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //取左边界到右边界，以upper为行，i为列从left到right 将上边界下移++upper
    //取上边界到下边界，以right为列，i为行从upper到down 将右边界左移--right
    //取右边界到左边界，以down为行，i为列从right到left 将下边界上移--down
    //取下边界到上边界，以left为列，i为行从down到upper 将左边界右移++left
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int upper = 0, down = m - 1, left = 0, right = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[upper][i]);
            }
            //上界下移 如果碰撞则说明已结束
            if (++upper > down) break;

            for (int i = upper; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            //右界左移
            if (--right < left) break;

            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            //下界上移
            if (--down < upper) break;
            for (int i = down; i >= upper; i--) {
                res.add(matrix[i][left]);
            }
            //左界右移
            if(++left>right) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
