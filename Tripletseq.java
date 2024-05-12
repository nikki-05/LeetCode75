class Solution {
    public boolean increasingTriplet(int[] nums) {
          if (nums == null || nums.length < 3)
            return false;
        
        int f = Integer.MAX_VALUE; //first
        int s = Integer.MAX_VALUE; //second
        
        for (int num : nums) {
            if (num <= f) {
                f= num;
            } else if (num <= s) {
                s = num;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
