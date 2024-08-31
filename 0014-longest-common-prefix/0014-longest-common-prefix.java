class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Start by assuming the first string is the common prefix
        String pre = strs[0];
        
        // Compare prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Adjust prefix until it matches the start of the current 
            while (strs[i].indexOf(pre) != 0) {
                // Shorten the prefix from the end by one character
                pre = pre.substring(0, pre.length() - 1);
                
                // If prefix becomes empty, there's no common prefix
                if (pre.isEmpty()) {
                    return "";
                }
            }
        }
        
        return pre;
    }
}