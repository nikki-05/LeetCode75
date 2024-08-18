class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         int count = 0, oddCount = 0, result = 0;
        int[] prefixCounts = new int[nums.length + 1];
        prefixCounts[0] = 1; 

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
            if (oddCount >= k) {
                result += prefixCounts[oddCount - k];
            }
            prefixCounts[oddCount]++;
        }

        return result;
    }
}