class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
         Arrays.sort(potions);
        
        int[] pairs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            // Binary search 
            int left = 0, right = potions.length - 1;
            int count = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long)spells[i] * potions[mid] >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                    count = mid + 1; // Update count to include potions[mid]
                }
            }
            pairs[i] = count;
        }
        
        // Adjust counts to represent the no. of successful pairs
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = potions.length - pairs[i];
        }
        
        return pairs;
    }
}