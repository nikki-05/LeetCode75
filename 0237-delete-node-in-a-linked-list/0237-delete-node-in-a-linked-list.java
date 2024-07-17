/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node){
      if (node == null || node.next == null) {
            throw new IllegalArgumentException("The node is invalid or it's the last node.");
        }
        
        // Copy the data from the next node to the current node
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        
        // Skip the next node
        node.next = nextNode.next;
        
    }
}