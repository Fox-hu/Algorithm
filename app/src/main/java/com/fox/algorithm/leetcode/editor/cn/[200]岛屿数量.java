//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2433 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //岛屿问题中 dfsGrid方法是一个常用模板 背下来 用于遍历连接起来的岛屿
    //那么本题中 遍历所有的陆地 当dfs遍历完成 那么就是一块岛屿 因为有标记重复 不会对岛屿进行重复计算
    //那么当所有的陆地遍历完 那么岛屿数目就出来了
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfsGrid(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfsGrid(char[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
            return;
        }
        //海水或者已处理过 跳出
        if (grid[row][col] != '1') {
            return;
        }
        //标记已经处理过
        grid[row][col] = '2';
        //查询上方格子
        dfsGrid(grid, row - 1, col);
        dfsGrid(grid, row, col - 1);
        dfsGrid(grid, row, col + 1);
        dfsGrid(grid, row + 1, col);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
