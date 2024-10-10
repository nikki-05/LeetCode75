class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
    
    for (int i = 0; i <= n; i++) {
        ans[i] = countO(i);
    }
    
    return ans;
    }
    private int countO(int num) {
    int count = 0;
    
    while (num > 0) {
        count += num & 1;
        num >>= 1;
    }
    
    return count;
    }
}