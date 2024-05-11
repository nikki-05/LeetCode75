class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); //Remove leading and trailing spaces &split
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" "); 
                // Adding space only if it's not the last word
            }
        }

        return reversed.toString();
    }
}
