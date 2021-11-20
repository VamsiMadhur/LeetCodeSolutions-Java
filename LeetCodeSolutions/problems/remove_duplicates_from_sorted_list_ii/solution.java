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
        ListNode dummy = new ListNode(-1, head);
        ListNode node = head;
        ListNode prev = dummy;
        
        while(node != null) {
            boolean flag = false;
            while(node.next!=null && node.val == node.next.val) {
                node = node.next;
                flag = true;
            }
            if(!flag) {
                prev.next = node;
                prev = prev.next;
            } else {
                prev.next = node.next;
            }
            node = node.next;
        }
        return dummy.next;
    }
}