class Solution {
    public boolean parseBoolExpr(String expression) {
          Stack<Character> stack = new Stack<>();
        
        // Traverse the string character by character
        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == '(') {
                continue; // Ignore commas and opening parentheses
            } else if (ch == ')') {
                // Evaluate the expression inside the parentheses
                Stack<Character> innerStack = new Stack<>();
                
                // Pop values until we reach '('
                while (!stack.isEmpty() && stack.peek() != '(') {
                    innerStack.push(stack.pop());
                }
                
                // Pop '(' from the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                
                // Get the operator right before '('
                if (!stack.isEmpty()) {
                    char operator = stack.pop();
                    
                    // Perform the operation
                    boolean result = false;
                    if (operator == '&') {
                        result = true;
                        while (!innerStack.isEmpty()) {
                            result &= innerStack.pop() == 't'; // AND operation
                        }
                    } else if (operator == '|') {
                        result = false;
                        while (!innerStack.isEmpty()) {
                            result |= innerStack.pop() == 't'; // OR operation
                        }
                    } else if (operator == '!') {
                        // Negate the single value (NOT operation)
                        result = innerStack.pop() == 'f'; // NOT false means true
                    }

                    // Push the result ('t' or 'f') back to the stack
                    stack.push(result ? 't' : 'f');
                }
            } else {
                // Push the current character ('t', 'f', '!', '&', '|') onto the stack
                stack.push(ch);
            }
        }
        
        // The final result will be the last item on the stack
        return !stack.isEmpty() && stack.pop() == 't';
    
    }
}