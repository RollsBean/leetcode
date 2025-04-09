package algorithm.string.a_3_longestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复的最长字串
 */
class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 0) {
            return 0;
        }

        int maxLength = 0;
        int j = 0;
        Set<Character> sets = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            while (sets.contains(c)) {
                sets.remove(charArray[j]);
                j++;
            }
            sets.add(c);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        Solution2 solution2 = new Solution2();
        int i = solution2.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
