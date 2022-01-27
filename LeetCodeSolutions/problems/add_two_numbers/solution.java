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
        ListNode resultHead = new ListNode(0);
        ListNode result = resultHead;
        int carry = 0;
        while(l1!=null || l2!=null || carry !=0) {
            int val = (l1 != null? l1.val:0) + (l2 != null ? l2.val : 0)  + carry;
            result.next = new ListNode(val%10);
            carry = val/10;
            result = result.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return resultHead.next;
    }
}