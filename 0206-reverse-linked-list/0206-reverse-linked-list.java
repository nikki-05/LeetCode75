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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move prev and curr pointers one step forward
            prev = curr;
            curr = next;
        }

        // later prev will be pointing to the new head of the reversed list
        return prev;
    }
}