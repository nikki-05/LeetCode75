class Solution {
    public int maxVowels(String s, int k) {
           Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int maxi = 0;
        int currentVowels = 0;
        
        // Count vowels in the first window of length k
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
        }
        
        maxi = currentVowels;
        
        // Slide the window and update maxVowels
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                currentVowels--;
            }
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
            maxi = Math.max(maxi, currentVowels);
        }
        
        return maxi;
    }
}
