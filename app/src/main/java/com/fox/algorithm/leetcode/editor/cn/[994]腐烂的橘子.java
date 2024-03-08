//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 818 👎 0


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //最短距离问题 使用bfs进行遍历 那么结果就是其层数
    //首先 将所有腐烂橘子坐标入队
    //第一分钟是 将腐烂的橘子依次出队 每次出队都感染其上下左右四方的橘子 并将四周橘子入队
    //那么在每一轮入队的烂橘子都处理完成时 队列里就只剩下这一轮被感染的橘子 层数+1 继续进入下一次感染
    //当队列为空时 如果还有新鲜橘子 那么结果为-1 如果没有 那么就返回感染层数
    public int orangesRotting(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        Queue<int[]> rotQueue = new LinkedList<>();
        int newOrange = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    newOrange++;
                }
                if (grid[i][j] == 2) {
                    rotQueue.add(new int[]{i, j});
                }
            }
        }

        int level = 0;
        while (newOrange > 0 && !rotQueue.isEmpty()) {
            //层数+1
            level++;
            //这里的count会变化 所以每一层都要重新确定
            int count = rotQueue.size();
            for (int i = 0; i < count; i++) {
                int[] rot = rotQueue.poll();
                int rotR = rot[0], rotC = rot[1];
                //找到上方新鲜橘子 将其感染 添加到下一轮感染处理队列
                if (rotR - 1 >= 0 && grid[rotR - 1][rotC] == 1) {
                    newOrange--;
                    grid[rotR - 1][rotC] = 2;
                    rotQueue.add(new int[]{rotR - 1, rotC});
                }
                if (rotR + 1 < r && grid[rotR + 1][rotC] == 1) {
                    newOrange--;
                    grid[rotR + 1][rotC] = 2;
                    rotQueue.add(new int[]{rotR + 1, rotC});
                }
                if (rotC - 1 >= 0 && grid[rotR][rotC - 1] == 1) {
                    newOrange--;
                    grid[rotR][rotC - 1] = 2;
                    rotQueue.add(new int[]{rotR, rotC - 1});
                }
                if (rotC + 1 < c && grid[rotR][rotC + 1] == 1) {
                    newOrange--;
                    grid[rotR][rotC + 1] = 2;
                    rotQueue.add(new int[]{rotR, rotC + 1});
                }
            }
        }
        if(newOrange > 0) return -1;
        return level;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
