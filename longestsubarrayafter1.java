class Solution {
    public int longestSubarray(int[] nums) {
         int left = 0; // Left pointer of the sliding window
        int maxi = 0; // Maximum length of subarray with only 1's
        int zeroCount = 0; // Count of zeros in the current window
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;

                // If there's more than 1 zeroin window, move left to the position after the previous zero
                while (zeroCount > 1) {
                    if (nums[left] == 0) {
                        zeroCount--;
                    }
                    left++;
                }
            }

            // Update maxSubarrayLength with the current window size
            maxi = Math.max(maxi, right - left);

        }
        if (maxih == nums.length) {
            return maxi - 1;
        }

        // If  no zeros in array,  delete 1 element to have  non-empty subarray of 1's
        if (zeroCount == 0) {
            return nums.length - 1;
        }

        return maxi;
    }
}
