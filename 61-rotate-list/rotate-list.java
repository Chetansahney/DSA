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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length and tail of the list
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Step 2: Effective rotations
        k = k % len;
        if (k == 0) return head; // no rotation needed

        // Step 3: Make it a circular list
        tail.next = head;

        // Step 4: Find new tail (len - k)th node
        ListNode newTail = head;
        for (int i = 1; i < len - k; i++) {
            newTail = newTail.next;
        }

        // Step 5: The node after newTail is the new head
        ListNode newHead = newTail.next;

        // Step 6: Break the circle
        newTail.next = null;

        return newHead;
    }
}
