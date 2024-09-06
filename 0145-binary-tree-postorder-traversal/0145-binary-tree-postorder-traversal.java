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
    public List<Integer> postorderTraversal(TreeNode root) {
         ArrayList<Integer> result = new ArrayList<>();
         helper(root, result);
        return result;
    }
    
    // Helper function 
    private void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        
        helper(root.left, result);
        helper(root.right, result); 
        result.add(root.val);
    }
}