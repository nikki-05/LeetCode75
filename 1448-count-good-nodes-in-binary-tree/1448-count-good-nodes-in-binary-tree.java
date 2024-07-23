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
    public int goodNodes(TreeNode root) {
         return count(root, Integer.MIN_VALUE);
    }
    private int count(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        // Check if the current node is a good node
        int good = 0; //goodnodescount
        if (node.val >= maxSoFar) {
            good = 1;
        }

        // Update the max value for the next recursive calls
        maxSoFar = Math.max(maxSoFar, node.val);

        // Count good nodes in the left and right subtrees
        good += count(node.left, maxSoFar);
        good += count(node.right, maxSoFar);

        return good;
    }
}