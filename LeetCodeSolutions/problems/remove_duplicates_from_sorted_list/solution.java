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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = head;
        ListNode prev = head;
        head = head.next;
        while(head != null) {
            if(prev.val == head.val) {
                head = head.next;
            } else {
                prev.next = head;
                prev = head;
            }
        }
        prev.next = null;
        return dummyHead;
    }
}