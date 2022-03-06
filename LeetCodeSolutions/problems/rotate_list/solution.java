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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null || head.next == null) return head;
        
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        
        ListNode tempHead = head;
        k = k%count;
        
        if(k == 0) return head;
        ListNode curr = head;
        for(int i=0; i<k; i++) curr = curr.next;
        temp = head;
        while(curr.next != null) {
            temp = temp.next;
            curr = curr.next;
        }
        ListNode result = temp.next;
        temp.next = null;
        curr.next = head;
        return result;
    }
}