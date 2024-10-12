class Solution {
    public int equalPairs(int[][] grid) {
         int n = grid.length;
        int count = 0;
        
        // Compare each row with each column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean match = true;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    count++;
                }
            }
        }
        
        return count;
    }
}