class Solution {
    public long subArrayRanges(int[] nums) {
         int n = nums.length;
        long sumMax = 0, sumMin = 0;

        for (int i = 0; i < n; i++) {
            int maxVal = nums[i], minVal = nums[i];
            for (int j = i; j < n; j++) {
                maxVal = Math.max(maxVal, nums[j]);
                minVal = Math.min(minVal, nums[j]);
                sumMax += maxVal;
                sumMin += minVal;
            }
        }

        return sumMax - sumMin;
    }
}