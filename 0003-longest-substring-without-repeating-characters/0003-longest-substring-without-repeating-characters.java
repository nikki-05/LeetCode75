class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
        int[] hasharr = new int[256]; 
        Arrays.fill(hasharr, -1); 
        int l = 0, r = 0, maxlen = 0;
        
        while (r < n) {
            char currentChar = s.charAt(r);
            if (hasharr[currentChar] != -1 && hasharr[currentChar] >= l) {
                l = hasharr[currentChar] + 1; 
            }
            
            int len = r - l + 1; 
            maxlen = Math.max(maxlen, len); 
            
            hasharr[currentChar] = r; 
            r++; 
        }
        return maxlen;
        
        
    }
}