package algorithm.backTracing.a_39_combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 39. 组合总和
 * <p/> 给定一个<strong>无重复元素</strong>的数组和 target，找出等于这个 target 的所有组合（可以重复使用某个元素）
 * 示例1 :
 * <pre>
 * <strong>输入</strong>：candidates = [2,3,6,7], target = 7
 * <strong>输出</strong>：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * </pre>
 */
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int current = 0;
        backtracking(candidates, target, 0, 1, result, tmp, current);
        return result;
    }

    public void backtracking(int[] candidates, int target, int startIdx, int deep, List<List<Integer>> result, List<Integer> tmp, int current) {
        if (current == target) {
            result.add(new ArrayList<>(tmp));
        }
        Arrays.sort(candidates);
        // 终止条件应该是 target 次，或者对数组排序，最少需要执行 ceil(target/min)
        if (tmp.size() == Math.ceil(target/candidates[0])) {
            return;
        }

        // 因为元素可以重复，所以每次都从 startIdx 开始遍历，而不是 startIdx + 1
        for (int i = startIdx; i < candidates.length; i++) {
            if (current + candidates[i] > target) {
                continue;
            }
            tmp.add(candidates[i]);
            current += candidates[i];
            backtracking(candidates, target, startIdx, ++deep, result, tmp, current);
            startIdx++;
            Integer last = tmp.removeLast();
            current -= last;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{8,7,4,3};
        int target = 11;
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        System.out.println(lists);
    }
}
