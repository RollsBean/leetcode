package algorithm.dynamicProgramming.a_121_maxProfit;

public class Solution {

    /**
     * 121. 买卖股票的最佳时机:动态规划
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 递推公式：dp[i] = max(dp[i-1], prices[i]-minPrice)

        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int deltaProfit = prices[i] - minPrice;
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, deltaProfit);

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxProfit(new int[]{1,2});
        System.out.println(i);
    }
}
