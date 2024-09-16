class Solution {
    public boolean isValidSudoku(char[][] board) {
         HashSet<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                
                if (number != '.') {
                    // Construct strings that uniquely identify a number in row, column, or box
                    String inRow = number + " in row " + i;
                    String inCol = number + " in col " + j;
                    String inBox = number + " in box " + (i / 3) * 3 + (j / 3);
                    
                    // Check if any of these strings has already been added to the set
                    if (!seen.add(inRow) || !seen.add(inCol) || !seen.add(inBox)) {
                        return false;
                    }
                }
            }
        }
        return true;
        
    }
}