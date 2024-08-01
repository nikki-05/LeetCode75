class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
         int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        // Start from room 0
        visited[0] = true;
        queue.add(0);
        
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            
            // Visit all keys/rooms
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }
        
        // Check if all rooms have been visited
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        
        return true;
    }
}