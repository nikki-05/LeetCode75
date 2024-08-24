class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sub(nums, goal)- sub(nums, goal-1);
    }

        private int sub(int[] nums, int goal){
        int l=0, r=0, sum=0, count=0;
        int n= nums.length;
        if(goal<0) return 0;
        while(r<nums.length){
            sum+= nums[r];
            while(sum>goal){
                sum-= nums[l];
                l=l+1;
            }
            count+= r-l+1;
            r=r+1;
        }
        return count;
    }
}