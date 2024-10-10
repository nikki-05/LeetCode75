import java.util.PriorityQueue;
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> frontQueue = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );
        PriorityQueue<int[]> backQueue = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        int left = 0;
        int right = n - 1;
        long totalCost = 0;

        // Initialize front queue
        for (int i = 0; i < candidates && left <= right; i++) {
            frontQueue.offer(new int[]{costs[left], left});
            left++;
        }
        
        // Initialize back queue
        for (int i = 0; i < candidates && left <= right; i++) {
            backQueue.offer(new int[]{costs[right], right});
            right--;
        }

        for (int i = 0; i < k; i++) {
            if (!frontQueue.isEmpty() && (backQueue.isEmpty() || frontQueue.peek()[0] < backQueue.peek()[0] 
                                          || (frontQueue.peek()[0] == backQueue.peek()[0] && frontQueue.peek()[1] < backQueue.peek()[1]))) {
                int[] cheapestWorker = frontQueue.poll();
                totalCost += cheapestWorker[0];
                if (left <= right) {
                    frontQueue.offer(new int[]{costs[left], left});
                    left++;
                }
            } else {
                int[] cheapestWorker = backQueue.poll();
                totalCost += cheapestWorker[0];
                if (left <= right) {
                    backQueue.offer(new int[]{costs[right], right});
                    right--;
                }
            }
        }

        return totalCost;
    }
}
 
