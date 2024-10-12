class Solution {
    public int largestAltitude(int[] gain) {
      int current= 0; // current altitude to 0
        int maxi = 0; //  maximum altitude to 0
        
        // Iterate through the gain array and calculate the cumulative altitude
        for (int i : gain) {
            current += i;
            maxi = Math.max(maxi, current); // Update the maximum altitude if needed
        }
        
        return maxi;  
    }
}