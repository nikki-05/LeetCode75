class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
         int n = arr.length;
        int[] pre = new int[n];
        int[] result = new int[queries.length];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {
                result[i] = pre[right];
            } else {
                result[i] = pre[right] ^ pre[left - 1];
            }
        }

        return result;
    }
}