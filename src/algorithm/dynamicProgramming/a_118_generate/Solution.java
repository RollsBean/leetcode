package algorithm.dynamicProgramming.a_118_generate;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> uppers = null;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> lines = new ArrayList<>(i);
            for (int j = 0; j < i-1; j++) {
                if (j == 0) {
                    lines.add(1);
                } else {
                    if (uppers != null) {
                        lines.add(uppers.get(j - 1) + uppers.get(j));
                    }
                }
            }
            lines.add(1);
            uppers = lines;
            result.add(lines);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(4);
        System.out.println(generate);
    }
}
