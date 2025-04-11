package algorithm.backTracing.a_131_splitParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Solution {

    public List<List<String>> partition(String s) {
        // 切割问题一般可以回溯法解决，回文串一般通过dp查
        List<List<String>> result = new ArrayList<>();
        // 1. dp 求回文串
        boolean[][] palindrome = isPalindrome(s);
        // 2. 回溯进行切割，start 就是切割点
        backtracking(s, result, new ArrayList<>(), 0, palindrome);
        return result;
    }


    private void backtracking(String s, List<List<String>> result, List<String> tmp, int start, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                tmp.add(s.substring(start, i+1));
                backtracking(s, result, tmp, i+1, dp);
                tmp.removeLast();
            }
        }
    }


    public boolean[][] isPalindrome(String s) {
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

        return dp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcba";
        List<List<String>> result = new ArrayList<>();
        boolean[][] palindrome = solution.isPalindrome(s);
        solution.backtracking(s, result, new ArrayList<>(), 0, palindrome);
        System.out.println(result);
    }


}
