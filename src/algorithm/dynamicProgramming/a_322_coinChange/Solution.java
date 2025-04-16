package algorithm.dynamicProgramming.a_322_coinChange;

/**
 * 322. 零钱兑换
 * <p>类似爬楼梯问题
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 定义 dp[i] 是 amount  = i 的零钱最少硬币个数，则有 dp[i] = min(dp[i - coins[coin]] + 1, dp[i]),coin 可能是多个币值，所以取最小值
        int[] dp = new int[amount + 1];

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 不能初始化为 Integer.MAX_VALUE，不然可能会溢出，因为后面有 +1 操作
            dp[i] = amount + 1;
            for (int coin = 0; coin < coins.length; coin++) {
                if (coins[coin] <= i) {
                    dp[i] = Math.min(dp[i-coins[coin]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        Solution solution = new Solution();
        int i = solution.coinChange(coins, 3);
        System.out.println(i);
    }
}
