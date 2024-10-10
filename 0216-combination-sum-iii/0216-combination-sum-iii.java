class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> combo, int k, int n, int start) {
        // If we have required elements and  sum is zero, add to result
        if (combo.size() == k && n == 0) {
            result.add(new ArrayList<>(combo));
            return;
        }
        
        // If combination size exceeds k or  sum becomes negative, stop further processing
        if (combo.size() > k || n < 0) {
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            combo.add(i);  // Choose the number
            backtrack(result, combo, k, n - i, i + 1);  // Explore further with reduced sum and next start number
            combo.remove(combo.size() - 1);  
        }
    }
}