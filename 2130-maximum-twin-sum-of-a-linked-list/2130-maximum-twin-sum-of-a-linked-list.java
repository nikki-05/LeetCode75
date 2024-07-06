/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
          List<Integer> values = new ArrayList<>();
        
        // Store the values of nodes in the list
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        int maxSum = Integer.MIN_VALUE;
        int n = values.size();
        
        // Calculate the maximum twin sum
        for (int i = 0; i < n / 2; i++) {
            int twinSum = values.get(i) + values.get(n - 1 - i);
            maxSum = Math.max(maxSum, twinSum);
        }
        
        return maxSum;
    
    }
}