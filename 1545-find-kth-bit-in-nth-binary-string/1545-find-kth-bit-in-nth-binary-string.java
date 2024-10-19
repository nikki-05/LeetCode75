class Solution {
    public char findKthBit(int n, int k) {
        return helper(n, k);
    }
    private char helper(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int length = (1 << n) - 1;
        int mid = length / 2 + 1; 

        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return helper(n - 1, k);
        } else {
            int pos = length - k + 1;
            char m = helper(n - 1, pos);
            return m == '0' ? '1' : '0';
        }
    
    }
}