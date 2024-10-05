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
    public boolean isValidBST(TreeNode root) {
        return isvalid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isvalid(TreeNode root, long mini, long maxi) {
        if (root == null) return true;
        if (root.val <= mini || root.val >= maxi) return false;
        return isvalid(root.left, mini, root.val) && isvalid(root.right, root.val, maxi);
    }
}