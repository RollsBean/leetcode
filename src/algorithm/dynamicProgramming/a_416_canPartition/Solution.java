package algorithm.dynamicProgramming.a_416_canPartition;


/**
 * 416. 分割等和子集
 * <p>分成两个子集使得两个子集的和相等
 * <p>01背包问题
 */
class Solution {
    /**
     * 两个子集相等，也就是存在部分元素相加的和等于总和的一半，部分元素个数count >= 1 && < 数组长度
     * <br/>定义 dp[i][j] 是 0~i 个元素的和是否可以等于 j，元素可以是0个
     * <br/> <strong>进阶</strong>：一维数组：dp[j] 是数组中元素是否和可以等于 j
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total+=nums[i];
        }
        if (total%2 == 1) {
            return false;
        }
        int half = total/2;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (maxNum > half) {
            // 如果数组中最大的元素大于 half，则total - maxNum < half，其他所有元素和小于 half，不会等于 half
            return false;
        }
        // dp[j] 表示和为 j 时是否存在这个组合
        boolean[] dp = new boolean[half + 1];
        if (nums[0] <= half) {
            dp[0] = true;
        }
        // 改为一维数组
        for (int i = 1; i < nums.length; i++) {
            for (int j = half; j >= 0; j--) {
                if (nums[i] <= j) {
                    // dp[i - 1][j] 不放 i 时是否存在和==j或者 放 i 了，所以0～i-1存在和等于和-i，即dp[i - 1][half - nums[i]] = true
                    dp[j] |= dp[j - nums[i]];
                }
            }
        }
        for (int j = 0; j <= half; j++) {
            System.out.println(dp[j] + " ");
        }
        return dp[half];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.canPartition(new int[]{3,3,3,4,5});
        System.out.println("result: " + b);
    }
}
