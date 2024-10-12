class Solution {
    public int minReorder(int n, int[][] connections) {
         Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] conn : connections) {
            graph.get(conn[0]).add(new int[]{conn[1], 1}); // original direction
            graph.get(conn[1]).add(new int[]{conn[0], 0}); // reverse direction
        }

        // BFS to count the minimum number of reorders
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;
        int c = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int[] neighbor : graph.get(current)) {
                int next = neighbor[0]; //next=nextcity
                int direction = neighbor[1];
                if (!visited[next]) {
                    visited[next] = true;
                    c += direction;
                    queue.add(next);
                }
            }
        }

        return c;
    }
}