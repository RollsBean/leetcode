package algorithm.dynamicProgramming.a_139_wordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        int maxLength = 1;
        int minLength = 20;
        for (String string : dictSet) {
            maxLength = Math.max(string.length(), maxLength);
            minLength = Math.min(string.length(), minLength);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && i - j <= maxLength && i - j >= minLength && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean b = solution.wordBreak(s, wordDict);
        System.out.println(b);
    }
}
