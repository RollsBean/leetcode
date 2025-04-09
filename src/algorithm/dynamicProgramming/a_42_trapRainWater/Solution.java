package algorithm.dynamicProgramming.a_42_trapRainWater;

class Solution {

    protected int trap(int[] height) {
        int length = height.length;
        if (length == 1) {
            return 0;
        }
        int[] maxL = new int[length];
        int[] maxR = new int[length];
        for (int i = 0; i < length; i++) {
            int maxLV = 0;
            int maxRV = 0;
            for (int j = 0; j < i; j++) {
                // 左边最大
                if (height[j] > maxLV) maxLV = height[j];
            }
            maxL[i] = maxLV;

            for (int j = i; j < length; j++) {
                // 右边最大
                if (height[j] > maxRV) maxRV = height[j];
            }
            maxR[i] = maxRV;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            int minSide = Math.min(maxL[i], maxR[i]);
            result +=  Math.max(minSide - height[i], 0);
        }
        return result;
    }

    private int getMax(int[] height) {
        int i = 1;
        int max = height[0];
        while (i < height.length) {
            if (height[i] > max) {
                max = height[i];
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = solution.trap(height);
        System.out.println(trap);
    }
}
