class Solution {
    public int maxOperations(int[] nums, int k) {
         Arrays.sort(nums); // Sort the array
        int left = 0, right = nums.length - 1;
        int maxi= 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                maxi++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return maxi;
    }
}