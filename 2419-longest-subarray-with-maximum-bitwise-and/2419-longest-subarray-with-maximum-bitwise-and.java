class Solution {
    public int longestSubarray(int[] nums) {
         int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        
        int maxLength = 0;
        int currentLength = 0;
        
        for (int num : nums) {
            if (num == maxValue) {
                
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }
        }
        
        maxLength = Math.max(maxLength, currentLength);
        
        return maxLength;
    }
}