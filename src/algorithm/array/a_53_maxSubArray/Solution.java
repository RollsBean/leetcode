package algorithm.array.a_53_maxSubArray;

/**
 * 53. 最大子数组和（连续元素）
 */
public class Solution {

    /**
     * dp，转移方程：定义 dp[i] 是第 i+1 个元素为结尾的数组的最大和，所以 dp[i] = Math.max(dp[i-1] + nums[i], nums[i])
     * <br/>示例：[-2,1,-3,4,-1,2,1,-5,4]
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        // 定义dp[i] 是第i+1个元素作为结尾的最大数组和
        int max = nums[0];
        int maxI = max;
        for (int i = 1; i < length; i++) {
            maxI = Math.max(nums[i], maxI + nums[i]);
            max = Math.max(max, maxI);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        int i = solution.maxSubArray(arr);
        System.out.println(i);
    }
}
