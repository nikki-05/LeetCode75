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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        while (!queue.isEmpty()) {
            int Size = queue.size();
            long Sum = 0;
            for (int i = 0; i < Size; i++) {
                TreeNode current = queue.poll();
                Sum += current.val;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            minHeap.offer(Sum);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.size() < k ? -1 : minHeap.peek();
    }
}