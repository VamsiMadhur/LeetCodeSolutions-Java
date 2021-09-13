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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode newHead = new ListNode(0,head);
        ListNode ptr = newHead;
        for(int i=0; i<left-1; i++) {
            ptr = ptr.next;
        }
        ListNode leftNode = ptr;
        ListNode temp1 = ptr.next;
        ListNode prev = null;
        ptr = ptr.next;
        for(int i=left; i<=right; i++) {
            ListNode temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
            
        }
        temp1.next = ptr;
        leftNode.next = prev;
        return newHead.next;
    }
}