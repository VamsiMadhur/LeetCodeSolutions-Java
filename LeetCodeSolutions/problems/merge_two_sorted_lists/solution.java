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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode previous = null;
        ListNode result = null;
        while(l1 != null && l2 != null) {
            ListNode current = new ListNode();
            if(l1.val <= l2.val) {
                current.val = l1.val;
                l1=l1.next;
            } else {
                current.val = l2.val;
                l2 = l2.next;
            }
            if(previous == null) {
                result = current;
            } else {
                previous.next = current;
            }
            previous = current;
        }
        if(l1 == null) {
            while(l2 != null) {
                ListNode current = new ListNode(l2.val);
                if(previous == null) {
                    result = current;
                } else {
                    previous.next = current;
                }
                l2 = l2.next;
                previous = current;
            }
        }
        if(l2 == null) {
            while(l1 != null) {
                ListNode current = new ListNode(l1.val);
                if(previous == null) {
                    result = current;
                } else {
                    previous.next = current;
                }
                l1 = l1.next;
                previous = current;
            }
        }
        return result;
    }
}