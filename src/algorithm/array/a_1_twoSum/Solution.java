package algorithm.array.a_1_twoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和，返回相加等于 target 的数组下标（从小到大顺序排列）
 */
class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length + 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int j = target - num;
            if (map.containsKey(j)) {
                return new int[]{i, map.get(j)};
            } else {
                map.put(num, i);
            }
        }
        return new int[0];
    }

}
