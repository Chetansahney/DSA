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
    public ListNode swapPairs(ListNode head) {
        // Dummy node before head to simplify swapping the first pair
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;

        // Traverse while at least two nodes are available to swap
        while (temp.next != null && temp.next.next != null) {
            // Identify nodes to swap
            ListNode first = temp.next;
            ListNode second = temp.next.next;

            // Swap nodes
            first.next = second.next;
            second.next = first;
            temp.next = second;

            // Move 'temp' two nodes ahead
            temp = first;
        }

        return dummy.next;
    }
}
