class Solution {
    public int findPeakElement(int[] nums) {
         int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is a peak
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                // Peak lies to the left
                right = mid - 1;
            } else {
                // Peak lies to the right
                left = mid + 1;
            }
        }
        
        // If left == right, it's the peak
        return left;
    }
}