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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) {
                break;
            }

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;

            // Reverse the current k-group
            reverseLL(groupStart, k);

            // Link the reversed group with the previous part of the list
            prevGroupEnd.next = kthNode;
            groupStart.next = nextGroupStart;

            // Move to the next group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }

    private void reverseLL(ListNode start, int k) {
        ListNode prev = null;
        ListNode curr = start;

        while (k > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
    }
}