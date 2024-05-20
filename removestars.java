class Solution {
    public String removeStars(String s) {
         Stack<Character> stack = new Stack<>();
        
        // Traverse each character in the string
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // When we encounter a star, pop the top element from the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // If it's not a star, push the character onto the stack
                stack.push(c);
            }
        }
        
        // Collect the result from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        // Convert StringBuilder to String and return
        return result.toString();
    
    }
}
