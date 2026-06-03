/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = calcSize(headA);
        int size2 = calcSize(headB);

        int diff = Math.abs(size1-size2);
        ListNode trav = size1>size2?headA:headB;

        while(trav!=null && diff-->0) {
            trav = trav.next;
        }

        ListNode trav2 = size1>size2?headB:headA;

        while(trav2!=null && trav!=null) {
            if(trav==trav2){
                return trav;
            }
            trav2=trav2.next;
            trav=trav.next;
        }

        return null;
        
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