class Solution {
    public String decodeString(String s) {
             StringBuilder result = new StringBuilder();
         Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(result);
                result = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                StringBuilder temp = result;
                result = stringStack.pop();
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    result.append(temp);
                }
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}