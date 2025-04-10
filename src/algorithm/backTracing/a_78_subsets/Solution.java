package algorithm.backTracing.a_78_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集：给定一个数组，返回所有可能的子集，包含它本身
 * <p/>示例1：
 * <pre>
 *     输入：nums = [1,2,3]
 *     输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * </pre>
 */
class Solution {

    /**
     * 回溯：
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int startIdx = 0;
        List<Integer> tmp = new ArrayList<>();
        backtracking(nums, startIdx, result, tmp);
        return result;
    }

    private void backtracking(int[] nums, int startIdx, List<List<Integer>> result, List<Integer> tmp) {
        // 回溯步骤：
        // 1. 终止条件-所有条件都满足，直接 set
        result.add(new ArrayList<>(tmp));

        for (int i = startIdx; i < nums.length; i++) {
            // 循环
            //  递归调用
            tmp.add(nums[i]);
            backtracking(nums, i + 1, result, tmp);
            //  remove 中间过程
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
