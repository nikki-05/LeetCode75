class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int subsetCount = 1 << n;  // 2^n subsets

        for (int i = 0; i < subsetCount; i++) {
            List<Integer> ls = new ArrayList<>(); //currentsubset
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    ls.add(nums[j]);
                }
            }
            result.add(ls);
        }

        return result;
    }
}