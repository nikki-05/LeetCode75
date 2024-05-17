class Solution {
    public double findMaxAverage(int[] nums, int k) {
         int n = nums.length;
        double maxSum = 0;
        double windowSum = 0;

        // Calculate initial window sum
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        for (int i = k; i < n; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
        
    }
}
