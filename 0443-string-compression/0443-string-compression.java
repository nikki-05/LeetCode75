class Solution {
    public int compress(char[] chars) {
         if (chars == null || chars.length == 0) return 0;
        
        int index = 0; // Index to write compressed characters into chars array
        int count = 1; // Count  repeating characters
        char current= chars[0]; // Current character 
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == current) {
                count++;
            } else {
                chars[index++] = current;
                if (count > 1) {
                    String cs = String.valueOf(count);
                    for (char c : cs.toCharArray()) {
                        chars[index++] = c;
                    }
                }
                current = chars[i];
                count = 1;
            }
        }
        
        // Write the last character and its count
        chars[index++] = current;
        if (count > 1) {
            String cs = String.valueOf(count);
            for (char c : cs.toCharArray()) {
                chars[index++] = c;
            }
        }
        
        return index;
    
    }
}