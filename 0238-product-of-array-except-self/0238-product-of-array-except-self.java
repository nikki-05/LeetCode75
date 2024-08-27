class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate the product of all elements to the left of each element
        int p = 1;
        for (int i = 0; i < n; i++) {
            result[i] = p;
            p *= nums[i];
        }
        
        // Calculate the product of all elements to the right of each element
        int rp = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rp;
            rp *= nums[i];
        }
        
        return result;
        
    }
}