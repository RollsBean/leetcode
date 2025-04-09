package algorithm.string.a_3_longestSubstring;


import java.util.HashSet;
import java.util.LinkedList;

/**
 * 难度：中等
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: 景行
 * @create: 2021/02/27
 **/
class Solution {

    /**
     * 思路：
     * <p/>
     *     滑动窗口问题，从左开始，滑动列表，遇到重复字段，删除前面重复的字段
     * <p/>
     * HashSet 去重
     * <p/>
     * LinkedList 用于保存当前不重复的连续集合
     * <p/>
     * 缺点：每次更新列表都需要判断最大长度，可以优化；
     * 内存消耗太大
     * <p/>
     * 链接：@see <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/</a>
     *
     * @param s
     * @return 长度
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Integer> set = new HashSet<>(16);
        LinkedList<Integer> list = new LinkedList<>();
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();// 记录两个重复字符间的距离
        int maxLength = 1;
        for (int i = 0; i < chars.length; i++) {
            int tNum = chars[i];
            if (!set.contains(tNum)) {
                list.addLast(tNum);
                set.add(tNum);
                if (list.size()>maxLength) {
                    maxLength = list.size();
                }
            } else {
                // 重复了,从头滑动窗口
                // 重新计算重复字符长度的起始位
                list.addLast(tNum);
                while (true) {
                    Integer first = list.pollFirst();
                    if (first == tNum) {
                        if (list.size()>maxLength) {
                            maxLength = list.size();
                        }
                        break;
                    }
                    set.remove(first);
                }

            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "sdfhsdfewrsd";
        String s = "tmmzuxt";
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
