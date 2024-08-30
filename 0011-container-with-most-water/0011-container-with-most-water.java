class Solution {
    public int maxArea(int[] height) {
         int maxi = 0; //max area
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int minH = Math.min(height[left], height[right]);
            int currentArea = minH * (right - left); 
            maxi = Math.max(maxi, currentArea);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxi;
    }
}