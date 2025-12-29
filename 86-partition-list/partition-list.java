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
    public ListNode partition(ListNode head, int x) 
    {
        ListNode smalldummy=new ListNode(0);
        ListNode largedummy=new ListNode(0);
        ListNode small=smalldummy;
        ListNode large=largedummy;
        ListNode temp=head;

        while(temp!=null)
        {
            if(temp.val<x)
            {
                small.next=temp;
                small=small.next;
            }
            else
            {
                large.next=temp;
                large=large.next;
            }temp=temp.next;
        }
        large.next=null;
        small.next=largedummy.next;
        return smalldummy.next;
    }
}