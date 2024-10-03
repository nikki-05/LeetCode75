class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        int target = (int) (total % p);
        if (target == 0) {
            return 0; 
        }
       
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1);
        
        int current = 0;
        int mini= n;
        long prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix+= nums[i];
            current = (int) (prefix % p);
            int need = (current - target + p) % p;
            
            if (mpp.containsKey(need)) {
                int index = mpp.get(need);
                mini = Math.min(mini, i - index);
            }
            mpp.put(current, i);
        }
        return mini == n ? -1 : mini;
    }
}