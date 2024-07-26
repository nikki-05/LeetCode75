/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
         HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Base case: a prefix sum of 0 exists once
        return dfs(root, 0, targetSum, prefixSumCount);
    }
        private int dfs(TreeNode node, long currSum, int targetSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        // Update the current prefix sum
        currSum += node.val;

        // Calculate the number of valid paths ending at the current node
        int numPathsToCurr = prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // Update the prefix sum count map
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // Recur for the left and right children
        int result = numPathsToCurr + dfs(node.left, currSum, targetSum, prefixSumCount)
                                    + dfs(node.right, currSum, targetSum, prefixSumCount);

        // Backtrack: remove the current node's value from the prefix sum count map
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return result;  
    }
}