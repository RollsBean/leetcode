package algorithm.array.a_15_threeSum;

import java.util.*;

/**
 * 15. 三数之和
 */
class Solution {

    /**
     * 暴力解法-三循环 - 无法去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0
                            && (!sets.contains(nums[i]) || !sets.contains(nums[j]) || !sets.contains(nums[k]))) {
                        List<Integer> objects = new ArrayList<>(3);
                        objects.add(nums[i]);
                        objects.add(nums[j]);
                        objects.add(nums[k]);
                        result.add(objects);
                        sets.add(nums[i]);
                        sets.add(nums[k]);
                        sets.add(nums[j]);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 先排序再双指针，去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        for (int s = 0; s < length - 2; s++) {
            int start = nums[s];
            // 这里处理类似[0,0,0,0,0]这样的重复元素问题
            if (s > 0 && nums[s-1] == start) {
                continue;
            }
            int i = s + 1;
            int j = length - 1;
            while (i < j) {
                // 处理 i j 重复的场景
                if (i > s+1 && nums[i - 1] == nums[i]) {
                    i++;
                    continue;
                }
                if (j < length - 1 && nums[j] == nums[j + 1]) {
                    j--;
                    continue;
                }
                if (start + nums[i] + nums[j] > 0) {
                    // 大于0
                    if (j-1 > i) {
                        j--;
                    } else {
                        break;
                    }
                } else if (start + nums[i] + nums[j] < 0){
                    // 小于0
                    if (i+1 < j) {
                        i++;
                    } else {
                        break;
                    }
                } else {
                    // 等于0
                    List<Integer> group = new ArrayList<>(3);
                    group.add(start);
                    group.add(nums[i]);
                    group.add(nums[j]);
                    result.add(group);
                    i++;
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        int[] nums1 = new int[]{-1,-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum2(nums1);
    }

}
