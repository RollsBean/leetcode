package algorithm.dynamicProgramming.a_746_minCostClimb;

/**
 * 动态规划问题：最小花费爬楼梯
 * <p/>
 * <pre>
 *     1.定义状态：如果是到第 i 个元素的值如何表示
 *     2.分析子问题：中间某一个元素如何推导
 *     3.根据（2）写出状态转移方程，第 i 个元素的值等于什么
 *     4.初始化：已知的初始节点，比如第一个节点
 * <pre/>
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 1.定义状态:到达第 i 个台阶的最小花费
        int length = cost.length;
        int[] dp = new int[length];
        // 分析子问题，写出状态转移方程

        // 初始化，只能从第一个台阶或第二个台阶开始
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[length - 1], dp[length - 2]);
    }

    public int minCostClimbingStairs_1(int[] cost) {
        // 1.定义状态:到达第 i 个台阶的最小花费,实际上第 i 个台阶只需要知道 第 i-1 和 i-2 的值
        int length = cost.length;
//        int[] dp = new int[length];
        // 分析子问题，写出状态转移方程

        // 初始化，只能从第一个台阶或第二个台阶开始
        int prev1 = cost[0];
        int prev2 = cost[1];
        // 是中间第 i 个台阶的最小花费
        int curr = 0;

        for (int i = 2; i < length; i++) {
            curr = Math.min(prev1, prev2) + cost[i];
            prev1 = prev2;
            prev2 = curr;
        }

        return Math.min(prev2, prev1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minCostClimbingStairs_1(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        int j = solution.minCostClimbingStairs_1(new int[]{10, 15, 20});
        System.out.println(i);
        System.out.println(j);
    }

}
