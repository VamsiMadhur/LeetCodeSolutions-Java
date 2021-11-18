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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1r = reverse(l1);
        ListNode h2r = reverse(l2);
        ListNode result = new ListNode();
        ListNode rh = result;
        int carry = 0;
        while(h1r!=null || h2r!=null || carry!=0) {
            result.next = new ListNode();
            result = result.next;
            int val = (h1r == null? 0:h1r.val) + (h2r == null? 0 : h2r.val) + carry;
            result.val = val%10;
            carry = val/10;
            h1r = (h1r == null)? null : h1r.next;
            h2r = (h2r == null)? null : h2r.next;
        }
        return reverse(rh.next);
        
    }
    
    public ListNode reverse(ListNode l1) {
        ListNode prev = null;
        while(l1 != null) {
            ListNode temp = l1.next;
            l1.next = prev;
            prev = l1;
            l1 = temp;
        }
        return prev;
    }
}