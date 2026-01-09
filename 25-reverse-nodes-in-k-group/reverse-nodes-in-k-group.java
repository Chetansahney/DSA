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
    public ListNode findKNode(ListNode head, int k)
    {
        ListNode temp=head;
        for(int i=1;i<k;i++)
        { if(temp==null) return null;
            temp=temp.next;
        }
        return temp;
    }
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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode temp=head;ListNode prevnode=null;
        while(temp!=null)
        {
            ListNode kthnode=findKNode(temp,k);
            if(kthnode==null)
            {
                if(prevnode!=null)
                {
                    prevnode.next=temp;
                    break;
                }

            }
            ListNode nextNode=kthnode.next;
            kthnode.next=null;
            ListNode reversed=reverse(temp);
            if(temp==head)
            {
                head=kthnode;
            }
            else
            {
                prevnode.next=kthnode;
            }
            prevnode=temp;
            temp=nextNode;

        }
        return head;
        

    }
}