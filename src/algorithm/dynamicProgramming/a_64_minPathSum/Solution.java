package algorithm.dynamicProgramming.a_64_minPathSum;

class Solution {
    public int minPathSum(int[][] grid) {
        // dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        int xLength = grid.length;
        int yLength = grid[0].length;
        int[][] dp = new int[xLength][yLength];
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[xLength-1][yLength-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int i = solution.minPathSum(grid);
        System.out.println(i);
    }
}
