package algorithm.backTracing.a_17_letterCombinations;

import java.util.*;

/**
 * 17. 电话号码组合
 * <p/>示例 1：
 * <pre>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * </pre>
 * <br/>限制：0 <= digits.length <= 4
 */
class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>(0);
        }

        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
        List<String> result = new ArrayList<>();

        int length = digits.length();
        List<List<String>> allWords = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 先根据数字的映射转成二维数组
            List<String> words = map.get(String.valueOf(digits.charAt(i)));
            allWords.add(words);
        }
        // 开始回溯流程
        backtracking(allWords, 0, result, new StringBuilder(), map);
        return result;
    }

    public void backtracking(List<List<String>> allWords, int startIdx, List<String> result, StringBuilder tmp, Map<String, List<String>> map) {
        int length = allWords.size();
        if (tmp.length() == length) {
            result.add(tmp.toString());
            return;
        }

        List<String> words = allWords.get(startIdx);
        for (int j = 0; j < words.size(); j++) {
            tmp.append(words.get(j));
            backtracking(allWords, startIdx+1, result, tmp, map);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "37";
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);
    }
}
