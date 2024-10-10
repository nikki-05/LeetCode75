class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        
        // Sort pairs in descending order
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        // Min-heap to keep track of top k elements from nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        long sum = 0;
        long maxScore = 0;
        
        for (int i = 0; i < n; i++) {
            int num1 = pairs[i][0];
            int num2 = pairs[i][1];
            
            // Add current num1 to min-heap and update sum
            minHeap.add(num1);
            sum += num1;
            
            // If the heap size> k, remove smallest from the heap and adjust sum
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            
            // If we have== k elements, calculate the potential 
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * num2);
            }
        }
        
        return maxScore;
    }
}