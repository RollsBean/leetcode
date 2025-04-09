package algorithm.dynamicProgramming.a_42_trapRainWater;

class Solution {

    protected int trap(int[] height) {
        int length = height.length;
        if (length == 1) {
            return 0;
        }
        int[] maxL = new int[length];
        maxL[0] = 0;
        int[] maxR = new int[length];
        maxR[length-1] = 0;
        for (int i = 1; i < length; i++) {
            // 定义 dp[i] 是第 i+1 个元素左边的最大值，公式 dp[i] = max( dp[i-1], height[i-1])
            maxL[i] = Math.max(maxL[i-1], height[i-1]);
        }
        for (int j = length - 2; j > 0; j--) {
            // 定义 dp[i] 是第 i+1 个元素右边的最大值，公式 dp[i] = max( dp[i+1], height[i+1])
            maxR[j] = Math.max(maxR[j+1], height[j+1]);
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            int minSide = Math.min(maxL[i], maxR[i]);
            result += Math.max(minSide - height[i], 0);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = solution.trap(height);
        System.out.println(trap);
    }
}
