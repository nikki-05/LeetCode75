class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            // The minimum cost to reach step i is the cost of step i + the minimum of the cost to reach the previous two steps
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        // The minimum cost to reach the top floor is the minimum of the cost to reach the last two steps
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}