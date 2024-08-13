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
        int size1 = calculateSize(headA);
        int size2 = calculateSize(headB);
        
        int sizeDiff = Math.abs(size1-size2);
        ListNode temp1,temp2;

        if(size1>size2) {
            temp1=headA;
            temp2=headB;
        }else{
            temp2=headA;
            temp1=headB;
        }

        int extraNodes = 0;
        while(temp1.next!=null && extraNodes<sizeDiff){
            temp1=temp1.next;
            extraNodes++;
        }

        while(temp1!=null && temp2!=null) {
            if(temp1==temp2){
                return temp1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }

    private static int calculateSize(ListNode head) {
        int count=0;
        ListNode temp = head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
}
