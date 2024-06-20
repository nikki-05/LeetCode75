class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            // Check if the current asteroid is moving to the right
            if (asteroid > 0) {
                stack.push(asteroid); // Add it to the stack
            } else {
                // Handle collisions with asteroids moving to the left
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop(); // Remove smaller asteroids moving to the right
                }
                
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid); // Add asteroid moving to the left or if stack is empty
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop(); // Both asteroids explode if they are the same size
                }
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}