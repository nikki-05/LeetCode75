class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] count= new int[k];
        for (int n : arr) {
            int rem = ((n % k) + k) % k; 
            count[rem]++;
        }
        for (int i = 0; i <= k / 2; i++) {
            if (i == 0) {
                if (count[i] % 2 != 0) {
                    return false;
                }
            } else {
                if (count[i] != count[k - i]) {
                    return false;
                }
            }
        }
        return true;
    }
}