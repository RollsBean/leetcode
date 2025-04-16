package algorithm.dynamicProgramming.a_279_numSquares;

/**
 * 279. 完全平方数
 * <p>输入 n，返回最少用几个完全平方数加和得到
 * <p>示例 1：<pre>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * </pre>
 */
class Solution {
    public int numSquares(int n) {
        // 转移方程： dp[i] = min(dp[i-s1*s1]+1, dp[i-s2*s2]+1, ,)
        int[] count = new int[n+1];
        // 处理 n = square*square 的情况，相减后就是 0 了，所以初始化为 0
        count[0] = 0;
        for (int i = 1; i <= n; i++) {
            int countI = n+1;
            int square = 1;
            while (square*square <= i) {
                countI = Math.min(count[i-square*square] + 1, countI);
                square++;
            }
            count[i] = countI;
        }
        return count[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int minCount = solution.numSquares(13);
        System.out.println(minCount);
    }
}
