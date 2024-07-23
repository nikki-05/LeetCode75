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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSequence1 = new ArrayList<>();
        List<Integer> leafSequence2 = new ArrayList<>();
        
        // Traverse the first tree and collect leaf node values into sequence 1
        collectLeafValues(root1, leafSequence1);
        
        // Traverse the second tree and collect leaf node values into sequence 2
        collectLeafValues(root2, leafSequence2);
        
        // Check if the sequences are equal
        return leafSequence1.equals(leafSequence2);
    }
    
    // Helper function to collect leaf node values into a sequence
    private void collectLeafValues(TreeNode node, List<Integer> sequence) {
        if (node == null) {
            return;
        }
        
        // If the node is a leaf, add its value to the sequence
        if (node.left == null && node.right == null) {
            sequence.add(node.val);
            return;
        }
        
        // Recursively collect leaf node values from left and right subtrees
        collectLeafValues(node.left, sequence);
        collectLeafValues(node.right, sequence);
    }
}