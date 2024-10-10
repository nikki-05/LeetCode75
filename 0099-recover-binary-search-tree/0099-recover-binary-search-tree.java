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
     private TreeNode first = null;
    private TreeNode last = null;
    private TreeNode prev = null;
    private TreeNode middle = null;

  private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // Check if the current node is out of order
        if (prev != null && root.val < prev.val) {
            // If it's the first occurrence of a mistake
            if (first == null) {
                first = prev;
                middle = root;
            }

            else {
                last = root;
            }
        }
        prev = root;

        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
       inorder(root);

        // If two swapped nodes are not adjacent (first and last are set)
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // If two swapped nodes are adjacent (first and middle are set)
        else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}