package algorithm.dynamicProgramming.a_5_longestPalindrome;

/**
 * 5. 最长回文子串
 * <p/>返回最长的回文串
 */
class Solution2 {

    /**
     * 返回最长的回文子串
     * <p/>参考《代码随想录》的遍历顺序，代码简化了，但是性能很差，仅击败 5%
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        String result = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                int length = j - i + 1;
                if (i == j) {
                    dp[i][j] = true;
                    result = length > result.length() ? s.substring(i, j + 1) : result;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    result = length > result.length() ? s.substring(i, j + 1) : result;
                } else if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    result = length > result.length() ? s.substring(i, j + 1) : result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String str = "c";
        String s = solution.longestPalindrome(str);
        System.out.println(s);
    }
}
