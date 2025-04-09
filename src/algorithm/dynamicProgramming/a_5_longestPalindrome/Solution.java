package algorithm.dynamicProgramming.a_5_longestPalindrome;

/**
 * 5. 最长回文字串
 */
class Solution {

    /**
     * dp:
     * <p/>需要处理 "ccc" 场景，即 i 与 i+1 相等同时 i-1 和 i+1 也相等的场景
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 1) {
            return s;
        }
        if (arr.length == 2) {
            if (arr[0] == arr[1]) {
                return s;
            } else {
                return s.substring(1);
            }
        }
        int length = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int j = 0;
            int k = 0;
            // dp[i][j] = if dp[i-1] == dp[j+1] -> dp[i][j] + 2
            if (arr[i] == arr[i+1]) {
                j = i-1;
                k = i+2;
                if (length < 2) {
                    length = 2;
                    maxStart = i;
                    maxEnd = i+1;
                }
                boolean isPalindrome = false;
                while (j >= 0 && k < arr.length && arr[j] == arr[k]) {
                    isPalindrome = true;
                    j--;
                    k++;
                }
                if (isPalindrome && k-j-1>length) {
                    length = k-j-1;
                    maxStart = ++j;
                    maxEnd = --k;
                }
            }
            // i == i + 1 的同时也可能出现 i-1 == i+1，比如 “ccc”，所以都需要考虑一遍
            j = i-1;
            k = i+1;
            boolean isPalindrome = false;
            while (j >= 0 && k < arr.length && arr[j] == arr[k]) {
                isPalindrome = true;
                j--;
                k++;
            }
            if (isPalindrome && k-j-1>length) {
                length = k-j-1;
                maxStart = ++j;
                maxEnd = --k;
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ccd";
        String s = solution.longestPalindrome(str);
        System.out.println(s);
    }
}
