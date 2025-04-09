package algorithm.dynamicProgramming.a_42_trapRainWater;

/**
 * 42. 接雨水
 */
class Solution {

    /**
     * <strong>动态规划</strong>求每个元素左右两侧的最大值，需要额外两个数组分别保存，左边最大值和右边的最大值
     * @param height
     * @return
     */
    public int trap(int[] height) {
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

    /**
     * dp 改进
     * <p/> 左右指针移动，两个指针分别指向第二个元素和倒数第二个元素，短板效应所以短边确定高度，确定后，当前元素的接水量就确定了，短边在左移
     * 动左边指针，短边在右移动右边指针
     * <br/>左右两个指针即是左右最大值的起始点，又是计算元素大小的点，比如左指针，左指针即用 leftMax 标识左边最大值，又标识当前计算接水的节点在
     * 左指针的位置
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int length = height.length;
        if (length == 1) {
            return 0;
        }
        int left = 1;
        int right = length - 2;
        int leftMax = height[0];
        int rightMax = height[length - 1];
        int result = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
//                result += Math.max(leftMax - height[left], 0);
                result += leftMax - height[left];
                left++;
            } else {
//                result += Math.max(rightMax - height[right], 0);
                result += rightMax - height[right];
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = solution.trap2(height);
        System.out.println(trap);
    }
}
