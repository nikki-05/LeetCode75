class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> addedNumbers;
    private int nextSmallest;


    public SmallestInfiniteSet() {
      
        minHeap = new PriorityQueue<>();
        addedNumbers = new HashSet<>();
        nextSmallest = 1;
        
    }
    
    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            addedNumbers.remove(smallest);
            return smallest;
        } else {
            return nextSmallest++;
        }
        
    }
    
    public void addBack(int num) {
         if (num < nextSmallest && addedNumbers.add(num)) {
            minHeap.offer(num);
         }
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */