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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        
        ListNode curr = head;
        ListNode part = dummyHead;
        ListNode prev = dummyHead;
        
        while(curr != null) {
            if(curr.val < x) {
                if(part!=prev) {
                    prev.next = curr.next;
                    curr.next = part.next;
                    part.next = curr;
                    part = curr;
                    curr = prev.next;
                } else {
                    part = curr;
                    prev = curr;
                    curr = curr.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
}