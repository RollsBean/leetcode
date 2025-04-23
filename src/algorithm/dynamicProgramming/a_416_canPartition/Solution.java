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
        boolean[][] dp = new boolean[nums.length][half+1];
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (maxNum > half) {
            // 如果数组中最大的元素大于 half，则total - maxNum < half，其他所有元素和小于 half，不会等于 half
            return false;
        }
        if (nums[0] <= half) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= half; j++) {
                if (nums[i] <= j) {
                    // dp[i - 1][j] 不放 i 时是否存在和==j或者 放 i 了，所以0～i-1存在和等于和-i，即dp[i - 1][half - nums[i]] = true
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= half; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        return dp[nums.length - 1][half];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.canPartition(new int[]{2,2,1,1});
        System.out.println(b);
    }
}
