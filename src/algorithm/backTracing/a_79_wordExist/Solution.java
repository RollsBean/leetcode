package algorithm.backTracing.a_79_wordExist;

/**
 * 79. 单词搜索
 * <p/>问题记录：
 * <pre>
 *     1. 找到的不是连续结果；
 * </pre>
 */
class Solution {

    private boolean exist = false;

    public boolean exist(char[][] board, String word) {
        backtracking(board, word, new StringBuilder());
        return exist;
    }

    private void backtracking(char[][] board, String word, StringBuilder tmp) {
        if (word.equals(tmp.toString())) {
            exist = true;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (exist) {
                break;
            }
            int prev = i;
            int next = i+1;
            for (int j = prev; j >= 0; j--) {
                if (tmp.length() < word.length() && board[i][j] == word.charAt(tmp.length())) {
                    tmp.append(board[i][j]);
                    backtracking(board, word, tmp);
                    tmp.deleteCharAt(tmp.length() - 1);
                }
            }
            for (int j = next; j < board[0].length; j++) {
                if (tmp.length() < word.length() && board[i][j] == word.charAt(tmp.length())) {
                    tmp.append(board[i][j]);
                    backtracking(board, word, tmp);
                    tmp.deleteCharAt(tmp.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCED";
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}
