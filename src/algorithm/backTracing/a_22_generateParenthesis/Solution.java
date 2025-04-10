package algorithm.backTracing.a_22_generateParenthesis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22. 括号生成
 */
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> list = Arrays.asList("(", ")");
        List<String> result = new ArrayList<>();
        backtracking(n, result, new StringBuilder(), 0, 0);
        return result;
    }

    private void backtracking(int n, List<String> result, StringBuilder tmp, int leftCount, int rightCount) {
        if (tmp.length() == 2*n) {
            result.add(tmp.toString());
            return;
        }

        if (leftCount < n) {
            tmp.append("(");
            backtracking(n, result, tmp, leftCount + 1, rightCount);
            tmp.deleteCharAt(tmp.length() - 1);
        }

        if (leftCount > rightCount) {
            tmp.append(")");
            backtracking(n, result, tmp, leftCount, rightCount + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }
}
