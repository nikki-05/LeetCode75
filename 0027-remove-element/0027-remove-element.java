class Solution {
    public int removeElement(int[] nums, int val) {
         int l = 0;
        for (int i = 0; i < nums.length; i++) { // i for right
            if (nums[i] != val) {
                nums[l] = nums[i]; // the right value becomes left
                l++;
            }
        }
        return l;
    }
}