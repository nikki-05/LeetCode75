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
      private Map<Integer, Integer> heights = new HashMap<>();  
    private Map<Integer, List<Integer>> levelHeights = new HashMap<>(); 
    public int[] treeQueries(TreeNode root, int[] queries) {
         helper(root, 0); 
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = helper2(root, queries[i]);
        }
        
        return result;
    }
     private int helper(TreeNode node, int level) {
        if (node == null) return -1;
        
        int leftHeight = helper(node.left, level + 1);
        int rightHeight = helper(node.right, level + 1);
        int nodeHeight = Math.max(leftHeight, rightHeight) + 1;
        
        heights.put(node.val, nodeHeight);
        levelHeights.computeIfAbsent(level, x -> new ArrayList<>()).add(nodeHeight);
        
        return nodeHeight;
    }

    private int helper2(TreeNode root, int query) {
        int maxt = 0;
        for (Map.Entry<Integer, List<Integer>> entry : levelHeights.entrySet()) {
            List<Integer> heightList = entry.getValue();
            if (heightList.size() > 1) {
                int maxL = heightList.stream().mapToInt(h -> h).max().orElse(0);
                maxt = Math.max(maxt, maxL);
            }
        }
        
        return maxt;
    }

}