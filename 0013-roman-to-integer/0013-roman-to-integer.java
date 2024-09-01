class Solution {
    public int romanToInt(String s) {
          Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        int result = 0;
        
        // Loop 
        for (int i = 0; i < s.length(); i++) {
            int value = romanValues.get(s.charAt(i));
        
            if (i + 1 < s.length() && value < romanValues.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        
        return result;
        
    }
}