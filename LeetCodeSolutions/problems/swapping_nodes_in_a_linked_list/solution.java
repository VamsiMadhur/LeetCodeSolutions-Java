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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0, head);
        ListNode prevfirst = dummy;
        ListNode first = head;
        for(int i=1; i<k; i++) {
            prevfirst = prevfirst.next;
            first = first.next;
        }
        ListNode fast = first, slow = head, prevSlow = dummy;
        while(fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
            prevSlow = prevSlow.next;
        }
        
        
        if(prevSlow == first) {
            ListNode temp = slow.next;
            prevfirst.next = slow;
            slow.next = first;
            first.next = temp;
        } else if(prevfirst == slow) {
            ListNode temp = first.next;
            prevSlow.next = first;
            first.next = slow;
            slow.next = temp;
        } else {
            ListNode temp = slow.next;
            prevfirst.next = slow;
            slow.next = first.next;
            prevSlow.next = first;
            first.next = temp;
        }
        
        return dummy.next;
    }
}