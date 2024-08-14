class Solution {
    public int maxProfit(int[] prices, int fee) {
         int n = prices.length;
        if (n == 0) return 0;
        
        int hold = -prices[0]; // Max profit if  hold a stock 
        int notHold = 0; // Maxprofit if  do not hold a stock 
        
        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            int prevNotHold = notHold;
            
            hold = Math.max(prevHold, prevNotHold - prices[i]);
            notHold = Math.max(prevNotHold, prevHold + prices[i] - fee);
        }
        
        return notHold;
    }
}