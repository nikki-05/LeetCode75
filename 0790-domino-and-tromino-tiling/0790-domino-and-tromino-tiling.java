class Solution {
    public int numTilings(int n) {
        final int MOD = 1000000007;
        
        if (n <= 1) return 1;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            for (int j = i - 3; j >= 0; j--) {
                dp[i] += 2 * dp[j];
                dp[i] %= MOD;
            }
        }
        
        return (int) dp[n];
    }
}