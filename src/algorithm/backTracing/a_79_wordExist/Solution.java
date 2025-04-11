package algorithm.backTracing.a_79_wordExist;

import java.util.Arrays;
import java.util.List;

/**
 * 79. 单词搜索
 * <p/>问题记录：
 * <pre>
 *     1. 找到的不是连续结果；
 *     2. 每一步都可以向上走、向左走
 * </pre>
 */
class Solution {

    private final List<List<Integer>> directions = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, -1),Arrays.asList(1, 0),Arrays.asList(-1, 0));

    public boolean exist(char[][] board, String word) {
        // 定义问题：走到[i][j] 时，如果和 word 中的第 k 个单词相等，那么接下来它只能向上下左右走一步
        // 走过了为true，直接跳过走下一步
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean exist = backtracking(board, word, visited, i, j, 0);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, boolean[][] visited, int x, int y, int k) {
        // 1. 终止条件
        if (board[x][y] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        boolean result = false;
        for (List<Integer> direction : directions) {
            int x1 = direction.get(0) + x;
            int y1 = direction.get(1) + y;
            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length && !visited[x1][y1]) {
                boolean exist = backtracking(board, word, visited, x1, y1, k + 1);
                if (exist) {
                    result = exist;
                    break;
                }
            }
        }
        visited[x][y] = false;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}
