class Solution {
    public long maxKelements(int[] nums, int k) {
          PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
        }
        
        long score = 0;
        for (int i = 0; i < k; i++) {
            int maxElement = maxHeap.poll();
            score += maxElement;
            int newElement = (int) Math.ceil(maxElement / 3.0);
            maxHeap.offer(newElement);
        }
        
        return score;
    }
}