package algorithm.backTracing.a_46_fullPermute;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 46. 全排列
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }

        backtracking(nums, result, new ArrayList<Integer>(), new HashSet<Integer>());
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> path, Set<Integer> existed) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (existed.contains(num)) {
                continue;
            }
            existed.add(num);
            path.add(num);
            backtracking(nums, result, path, existed);
            path.removeLast();
            existed.remove(num);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = solution.permute(nums);

        System.out.println(permute);
    }
}
