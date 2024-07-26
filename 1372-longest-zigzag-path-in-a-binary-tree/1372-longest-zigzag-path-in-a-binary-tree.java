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
        private int maxi=0;
    public int longestZigZag(TreeNode root) {
         if (root == null) return 0;
        // Start the DFS from the root node
        dfs(root, true, 0);  // Start by assuming a move to the right
        dfs(root, false, 0); // Start by assuming a move to the left
        return maxi;
    }

    private void dfs(TreeNode node, boolean isRight, int length) {
        if (node == null) return;
        maxi = Math.max(maxi, length);
        // If the last move was to right, move to the left, and vice versa
        if (isRight) {
            dfs(node.left, false, length + 1); // Move to the left and switch direction
            dfs(node.right, true, 1);          // Restart 
        } else {
            dfs(node.right, true, length + 1); // Move to the right and switch direction
            dfs(node.left, false, 1);  
        }
        
    }
}