class Solution {
    public int findPermutationDifference(String s, String t) {
      if (s == null || t == null || s.length() != t.length()) {
        }
        
        int diff= 0;
        
        // Iterate through each character in s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Find the index of the same character in t
            int indexInT = t.indexOf(ch);
            int d = Math.abs(i - indexInT);
            diff += d;
        }
        
        return diff;  
    }
}