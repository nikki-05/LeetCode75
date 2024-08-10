class Solution {
    public int findKthLargest(int[] nums, int k) {
          PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first K elements to the min heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // Iterate over the remaining elements
        for (int i = k; i < nums.length; i++) {
            // If the current element is larger than the smallest element in the heap, remove the smallest and add the current
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        // The top of the heap will be the Kth largest element
        return minHeap.peek();
        
    }
}