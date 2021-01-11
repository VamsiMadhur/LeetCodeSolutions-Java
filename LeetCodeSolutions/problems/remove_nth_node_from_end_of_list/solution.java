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
        
        ListNode p1 = head;
        ListNode p2 = p1;
        for(int i=0; i<n-1; i++) {
            
            p2 = p2.next;
        } 
        ListNode prev = null;
        while(p2.next !=null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(prev==null) {
            return p1.next;
        } else {
            prev.next=p1.next;
            p1.next=null;
         }
        
        return head;
    }
}