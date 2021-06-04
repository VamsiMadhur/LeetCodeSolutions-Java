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
        
        ListNode head1 = new ListNode(0);
        ListNode ptr1 = head1;
        
        ListNode head2 = new ListNode(0);
        ListNode ptr2 = head2;
        
        while(head!=null) {
            if(head.val < x) {
                    ptr1.next = head;
                    ptr1 = ptr1.next;
            } else {
                    ptr2.next = head;
                    ptr2 = ptr2.next;
            }
            head = head.next;
        }
        
        ptr1.next = head2.next;
        ptr2.next = null;
        return head1.next;
    }
}