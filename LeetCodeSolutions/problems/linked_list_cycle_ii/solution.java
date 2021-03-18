/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr2 = null;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                ptr2 = fast;
                break;
            }
        }
        
        if(ptr2 != null) {
            ListNode ptr1 = head;
            while(ptr1 != ptr2) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            } 
        }
        return ptr2;
    }
}