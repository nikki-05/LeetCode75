class Solution {
    public int divide(int dividend, int divisor) {
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean sign = (dividend >= 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        // Convert both numbers to positive long values to handle overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        // Use bit manipulation to find the quotient
        while (n >= d) {
            int count = 0;
            // Find the highest shift count such that (d << (count + 1)) <= n
            while (n >= (d << (count + 1))) {
                count++;
            }
            // Accumulate the result with the corresponding power of two
            ans += (1L << count);
            // Subtract the shifted divisor from n
            n -= (d << count);
        }

        // Handle overflow for positive cases
        if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        // Return the final result with the correct sign
        return sign ? (int) ans : (int) -ans;
    
        
    }
}