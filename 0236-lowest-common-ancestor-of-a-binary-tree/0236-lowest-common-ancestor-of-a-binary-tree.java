/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recurse on leftand right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left & right are non-null, p and q are in different subtrees, so root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (either left or right)
        return (left != null) ? left : right;
    }
}