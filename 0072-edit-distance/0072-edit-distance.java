class Solution {
    public int minDistance(String word1, String word2) {
         int m = word1.length();
        int n = word2.length();
        
        // to hold the mini operations to convert word1[0...i-1] to word2[0...j-1]
        int[][] dp = new int[m+1][n+1];
        
        // Initialize base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // To convert word1[0...i-1] to an empty string
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // To convert an empty string to word2[0...j-1]
        }
        
        // Fill dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        
        return dp[m][n];
    }
}