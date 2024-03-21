//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 回溯 矩阵 👍 1774 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遍历到word的首字符 开始进行回溯
                if (word.charAt(0) == board[i][j]) {
                    if (backtrack(board, word, i, j, 0, new boolean[m][n])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /***
     * @param board 网格
     * @param word 目标字符串
     * @param row 当前的行
     * @param col 当前的列
     * @param index 当前目标字符串的index
     * @param visited 标记是否访问过
     * @return 网格中是否存在目标字符串（从第0到index位的字符串）
     */
    private boolean backtrack(char[][] board, String word, int row, int col, int index,
            boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        if (backtrack(board, word, row - 1, col, index + 1, visited)
            || backtrack(board, word, row + 1, col, index + 1, visited)
            || backtrack(board, word, row, col - 1, index + 1, visited)
            || backtrack(board, word, row, col + 1, index + 1, visited)) {
            return true;
        }
        //回溯 一定要撤回 否则这个位置就不能再次访问了
        visited[row][col] = false;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
