class RecentCounter {
      private Queue<Integer> r;
    public RecentCounter() {
      
        r = new LinkedList<>();
    }
    
    public int ping(int t) {
           r.offer(t);
        while (r.peek() < t - 3000) {
            r.poll();
        }
        return r.size();
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */