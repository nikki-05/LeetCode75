class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        
        // Directions arrays for moving up, down, left, right
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};
        
        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});
        
        // Mark the entrance as visited by changing it to '+'
        maze[entrance[0]][entrance[1]] = '+';
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];
            
            // Check all four possible directions
            for (int i = 0; i < 4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                
                // Check if the new position is within bounds and is an empty cell
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze[newX][newY] == '.') {
                    // Check if it's an exit (on the border but not the entrance)
                    if (newX == 0 || newX == rows - 1 || newY == 0 || newY == cols - 1) {
                        return steps + 1;
                    }
                    // Mark the cell as visited and add it to the queue
                    maze[newX][newY] = '+';
                    queue.add(new int[]{newX, newY, steps + 1});
                }
            }
        }
        
        // If no exit is found
        return -1;
    }
}