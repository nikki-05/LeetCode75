class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         if (intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1]; 
        int count = 0; 
        
        for (int i = 1; i < intervals.length; i++) {
            // If an overlap with  current interval, increment count
            //  update end point to minimum of current & the end point of  current interval
            if (intervals[i][0] < end) {
                count++;
                end = Math.min(end, intervals[i][1]);
            } else {
                // If no overlap, update end point to  end point of  current interval
                end = intervals[i][1];
            }
        }
        return count;
    }
}