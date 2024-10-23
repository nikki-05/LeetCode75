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
    public TreeNode replaceValueInTree(TreeNode root) {
           if (root == null) return null;

        // This will hold the nodes at each depth level
        Map<Integer, List<TreeNode>> levelNodes = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        // Perform level order traversal and store nodes by depth
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevel = new ArrayList<>();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node);
                sum += node.val; // Calculate sum of this level

                if (node.left != null) {
                    parentMap.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    queue.offer(node.right);
                }
            }
            levelNodes.put(depth, currentLevel);
            depth++;
        }

        // Replace values with cousin sums
        for (int d = 0; d < depth; d++) {
            List<TreeNode> nodesAtDepth = levelNodes.get(d);
            int totalSum = 0;
            for (TreeNode node : nodesAtDepth) {
                totalSum += node.val; // Total sum at this depth
            }
            for (TreeNode node : nodesAtDepth) {
                // Set the node value to total sum of cousins
                // Exclude its parent's children and itself
                int cousinSum = totalSum - node.val;
                if (parentMap.containsKey(node) && parentMap.get(node) != null) {
                    TreeNode parent = parentMap.get(node);
                    if (parent.left != null) cousinSum -= parent.left.val;
                    if (parent.right != null) cousinSum -= parent.right.val;
                }
                node.val = cousinSum;
            }
        }

        return root;
    }
}