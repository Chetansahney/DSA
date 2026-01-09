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
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        return prev;

    }
    public void reorderList(ListNode head) 
    {
      ListNode slow=head;
      ListNode fast=head;
      while(fast!=null && fast.next!=null)
      {
        fast=fast.next.next;
        slow=slow.next;
      }  
      ListNode rev=reverse(slow);
      ListNode curr=head;
      while(rev.next!=null)
      {
        ListNode tempcurr=curr.next;
        curr.next=rev;
        ListNode temprev=rev.next;rev.next=tempcurr;
        curr=tempcurr;
        rev=temprev;
      }
    }
}