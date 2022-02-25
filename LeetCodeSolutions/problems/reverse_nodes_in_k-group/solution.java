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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode newHead = new ListNode(0);
        ListNode prevTail = newHead;
        
        int length = lengthOfLL(head);
        
        while(length >= k) {
            int count = k;
            ListNode prev = null;
            ListNode currHead = head;
            while(count !=0) {
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
                count--;
            }
            prevTail.next = prev;
            prevTail = currHead;
            length -= k;
        }
        prevTail.next = head;
        return newHead.next;
    }
    
    public int lengthOfLL(ListNode head) {
        int count = 0;   
        while(head!=null) {
            head = head.next;
            count++;
        }
        return count;
    }
}