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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = calcSize(head);
        // if(size==1)
        //     return null;
        int diff = size-n;

        if(diff==0){
            head=head.next;
            return head;
        }
        
        ListNode trav = head;
        while(--diff>0) {
            trav=trav.next;
        }

        trav.next = trav.next.next;
        
        return head;

    }

    private static int calcSize(ListNode node) {
        int size=0;
        while(node!=null) {
            size++;
            node=node.next;
        }
        return size;
    }
}