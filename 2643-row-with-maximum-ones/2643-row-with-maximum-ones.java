class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length; // Number of rows
        int n = mat[0].length; // Number of columns

        int maxOnes = 0; // Maximum number of ones found
        int maxRowIndex = 0; // Index of the row with the maximum number of ones

        // Traverse each row to find the row with the maximum number of ones
        for (int i = 0; i < m; i++) {
            int onesCount = countOnes(mat[i]);
            if (onesCount > maxOnes) {
                maxOnes = onesCount;
                maxRowIndex = i;
            }
        }

        return new int[]{maxRowIndex, maxOnes};
    }

    // Helper method to count the number of 1's in a row
    private int countOnes(int[] row) {
        int count = 0;
        for (int value : row) {
            if (value == 1) {
                count++;
            }
        }
        return count;
    }
}