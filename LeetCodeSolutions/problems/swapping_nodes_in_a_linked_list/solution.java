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
        
        boolean flag = (prevSlow == first);
        if(prevfirst == slow) {
            flag = true;
            ListNode temp1 = first, temp2 = prevfirst;
            first = slow;
            prevfirst = prevSlow;
            slow = temp1;
            prevSlow = temp2;
            
        }
        
        ListNode temp = slow.next;
        prevfirst.next = slow;
        if(flag) {
            slow.next = first;
            first.next = temp;
        } else {
            slow.next = first.next;
            prevSlow.next = first;
            first.next = temp;
        }
        
        return dummy.next;
    }
}