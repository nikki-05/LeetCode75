class Solution {
    public int minGroups(int[][] intervals) {
          List<int[]> arr = new ArrayList<>();
        
        for (int[] i : intervals) {
            arr.add(new int[] {i[0], 1});  
            arr.add(new int[] {i[1] + 1, -1}); 
        }
        
        arr.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int maxi = 0;
        int current = 0;
   
        for (int[] a: arr) {
            current += a[1];
            maxi = Math.max(maxi, current);
        }
        
        return maxi;
    
    }
}