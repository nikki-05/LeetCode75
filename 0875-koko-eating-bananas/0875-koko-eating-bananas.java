class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int left = 1;
        int right = getpile(piles);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (eatAll(piles, h, mid)) {
                right = mid;  // Try to find a smaller valid k
            } else {
                left = mid + 1;  // Increase k
            }
        }
        
        return left;
    }
    
    private int getpile(int[] piles) {
        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }
        return max;
    }
    
    private boolean eatAll(int[] piles, int h, int k) {
        int hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k;  // Equivalent to Math.ceil(pile / (double) k)
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}