class Solution {
    public int findMinArrowShots(int[][] points) {
           if (points == null || points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int ar = 1; // Initialize arrow =to 1,bcoz at least 1 arrow is needed
        int end = points[0][1]; // the end point with 1st balloon's end point
        for (int i = 1; i < points.length; i++) {
            // If the next balloon's start point is> the current end point,
            //for a new arrow, so incr. the ar and update the end point
            if (points[i][0] > end) {
                ar++;
                end = points[i][1];
            }
        }
        
        return ar;
    }
}