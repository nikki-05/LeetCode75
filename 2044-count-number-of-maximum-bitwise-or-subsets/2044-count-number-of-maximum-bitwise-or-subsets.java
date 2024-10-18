class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        
        int count = 0;
        int totalSubsets = 1 << n; 
        
        for (int i = 1; i < totalSubsets; i++) { 
            int currentOr = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  
                    currentOr |= nums[j];
                }
            }
            if (currentOr == maxOr) {
                count++;
            }
        }
        
        return count;
    }
}