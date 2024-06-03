class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0; // Left pointer of the sliding window
        int maxOnes = 0; // Maximum consecutive ones 
        int Count = 0; // Count of zeros in the current window

        // Iterate through the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                Count++;
            }

            // Shrink the window until zeroCount is less than or equal to k
            while (Count > k) {
                if (nums[left] == 0) {
                    Count--;
                }
                left++; // Move the left pointer to shrink the window size
            }

            // Update maxOnes with the current window size
            maxOnes = Math.max(maxOnes, right - left + 1);
        }

        return maxOnes; 
    }
}
