package algorithm.array.a_209_minSubArrayLen;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int sum = nums[0];
        int minLen = nums.length + 1;
        for(int i =0, j = i; i <= j;) {
            if (j >= nums.length) {
                return minLen;
            }

            if (sum >= target) {
                if (sum == target) {
                    minLen = Math.min(minLen, j - i + 1) ;
                }
                sum -= nums[i++];
            } else {
                sum += nums[++j];
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        System.out.println(i);
    }
}
